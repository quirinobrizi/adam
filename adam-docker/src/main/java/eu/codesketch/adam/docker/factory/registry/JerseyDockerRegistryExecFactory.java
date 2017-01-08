/**
 * Copyright [2016-17] [Quirino Brizi (quirino.brizi@gmail.com)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.codesketch.adam.docker.factory.registry;

import static com.google.common.base.Preconditions.checkNotNull;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.filter.JsonClientFilter;
import com.github.dockerjava.jaxrs.filter.ResponseStatusExceptionFilter;
import com.github.dockerjava.jaxrs.filter.SelectiveLoggingFilter;

import eu.codesketch.adam.docker.authorization.AuthenticationRequestFilter;
import eu.codesketch.adam.docker.authorization.AuthorizationProvider;
import eu.codesketch.adam.docker.authorization.strategy.BasicAuthorizationStrategy;
import eu.codesketch.adam.docker.authorization.strategy.BearerAuthorizationStrategy;
import eu.codesketch.adam.docker.authorization.strategy.NoneAuthorizationStrategy;
import eu.codesketch.adam.docker.command.registry.ListImageTagsCommand.Exec;
import eu.codesketch.adam.docker.command.registry.ListImageTagsCommandExec;

/**
 * @author quirino.brizi
 *
 */
public class JerseyDockerRegistryExecFactory implements DockerRegistryExecFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyDockerRegistryExecFactory.class.getName());

    private DockerClientConfig dockerClientConfig;

    private PoolingHttpClientConnectionManager connManager;

    private Client authorizationClient;
    private Client dockerRegistryClient;

    private WebTarget baseResource;

    /*
     * (non-Javadoc)
     * 
     * @see
     * eu.codesketch.adam.docker.factory.registry.DockerRegistryExecFactory#init
     * (com.github.dockerjava.core.DockerClientConfig)
     */
    @Override
    public void init(DockerClientConfig dockerClientConfig) {
        checkNotNull(dockerClientConfig, "config was not specified");
        this.dockerClientConfig = dockerClientConfig;

        ClientConfig clientConfig = prepareBasicClientConfig(dockerClientConfig);
        SSLContext sslContext = prepareSslContext();
        String originalUri = dockerClientConfig.getRegistryUrl();
        configureConnectionManager(clientConfig, sslContext, originalUri);
        authorizationClient = buildClient(clientConfig, sslContext);

        AuthorizationProvider authorizationProvider = new AuthorizationProvider(dockerClientConfig, Arrays.asList(
                new BasicAuthorizationStrategy(), new BearerAuthorizationStrategy(), new NoneAuthorizationStrategy()));
        clientConfig.register(new AuthenticationRequestFilter(authorizationProvider, authorizationClient));
        clientConfig.register(ResponseStatusExceptionFilter.class);

        dockerRegistryClient = buildClient(clientConfig, sslContext);
        baseResource = dockerRegistryClient.target(originalUri).path("v2");
    }

    private Client buildClient(ClientConfig clientConfig, SSLContext sslContext) {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder().withConfig(clientConfig)
                .hostnameVerifier(new TrustAllHostNameVerifier());
        if (sslContext != null) {
            clientBuilder.sslContext(sslContext);
        }
        return clientBuilder.build();
    }

    private void configureConnectionManager(ClientConfig clientConfig, SSLContext sslContext, String originalUri) {
        connManager = new PoolingHttpClientConnectionManager(getSchemeRegistry(originalUri, sslContext)) {

            @Override
            public void close() {
                super.shutdown();
            }

            @Override
            public void shutdown() {
                // Disable shutdown of the pool. This will be done later, when
                // this factory is closed
                // This is a workaround for finalize method on jerseys
                // ClientRuntime which
                // closes the client and shuts down the connection pool when it
                // is garbage collected
            }
        };
        clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connManager);
    }

    private ClientConfig prepareBasicClientConfig(DockerClientConfig dockerClientConfig2) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.connectorProvider(new ApacheConnectorProvider());
        clientConfig.property(CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE, true);

        clientConfig.register(JsonClientFilter.class);
        clientConfig.register(JacksonJsonProvider.class);

        // logging may disabled via log level
        clientConfig.register(new SelectiveLoggingFilter(LOGGER, true));
        return clientConfig;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * eu.codesketch.adam.docker.factory.registry.DockerRegistryExecFactory#
     * close()
     */
    @Override
    public void close() {
        this.connManager.close();
        this.authorizationClient.close();
        this.dockerRegistryClient.close();
    }

    private SSLContext prepareSslContext() {
        TrustManager[] certs = new TrustManager[] { new X509TrustManager() {

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        } };
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, certs, new SecureRandom());
            return context;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private org.apache.http.config.Registry<ConnectionSocketFactory> getSchemeRegistry(final String originalUri,
            SSLContext sslContext) {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
        registryBuilder.register("http", PlainConnectionSocketFactory.getSocketFactory());
        if (sslContext != null) {
            registryBuilder.register("https", new SSLConnectionSocketFactory(sslContext));
        }
        return registryBuilder.build();
    }

    protected WebTarget getBaseResource() {
        return baseResource;
    }

    protected DockerClientConfig getDockerClientConfig() {
        return dockerClientConfig;
    }

    @Override
    public Exec listImageTagsCmdExec() {
        return new ListImageTagsCommandExec(getBaseResource(), getDockerClientConfig());
    }

    public static class TrustAllHostNameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }

    }
}
