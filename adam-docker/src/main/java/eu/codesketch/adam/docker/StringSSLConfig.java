/**
 * 
 */
package eu.codesketch.adam.docker;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.SSLContext;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.glassfish.jersey.SslConfigurator;

import com.github.dockerjava.api.exception.DockerClientException;
import com.github.dockerjava.core.SSLConfig;
import com.github.dockerjava.core.util.CertificateUtils;

/**
 * @author quirino
 *
 */
public class StringSSLConfig implements SSLConfig {

    private final String certificateAuthority;
    private final String key;
    private final String certificate;

    public StringSSLConfig(String certificateAuthority, String key, String certificate) {
        this.certificateAuthority = certificateAuthority;
        this.key = key;
        this.certificate = certificate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.github.dockerjava.core.SSLConfig#getSSLContext()
     */
    @Override
    public SSLContext getSSLContext() throws KeyManagementException, UnrecoverableKeyException,
            NoSuchAlgorithmException, KeyStoreException {
        try {

            Security.addProvider(new BouncyCastleProvider());

            // properties acrobatics not needed for java > 1.6
            String httpProtocols = System.getProperty("https.protocols");
            System.setProperty("https.protocols", "TLSv1");
            SslConfigurator sslConfig = SslConfigurator.newInstance(true);
            if (httpProtocols != null) {
                System.setProperty("https.protocols", httpProtocols);
            }

            sslConfig.keyStore(CertificateUtils.createKeyStore(key, certificate));
            sslConfig.keyStorePassword("docker");
            sslConfig.trustStore(CertificateUtils.createTrustStore(certificateAuthority));

            return sslConfig.createSSLContext();

        } catch (Exception e) {
            throw new DockerClientException(e.getMessage(), e);
        }
    }

}
