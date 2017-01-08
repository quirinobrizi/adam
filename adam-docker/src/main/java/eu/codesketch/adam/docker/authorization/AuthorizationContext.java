package eu.codesketch.adam.docker.authorization;

import java.net.URI;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.codesketch.adam.docker.authorization.strategy.AuthorizationStrategy.AuthorizationType;

public class AuthorizationContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationContext.class);

    private final String authorizationType;
    private final String realm;
    private final String service;
    private final String scope;

    private final Client client;

    private AuthorizationContext(String authorizationType, String realm, String service, String scope, Client client) {
        this.authorizationType = authorizationType;
        this.realm = realm;
        this.service = service;
        this.scope = scope;
        this.client = client;
    }

    public AuthorizationType getAuthorizationType() {
        return AuthorizationType.fromAlias(null == authorizationType ? "none" : authorizationType);
    }

    public String getRealm() {
        return realm;
    }

    public String getScope() {
        return scope;
    }

    public String getService() {
        return service;
    }

    public Client getClient() {
        return client;
    }

    public static Optional<AuthorizationContext> discover(Client client, URI uri) {
        Response response = client.target(uri).request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 401) {
            String wwwAuthenticate = response.getHeaderString(HttpHeaders.WWW_AUTHENTICATE);
            LOGGER.info("authenticate with registry for: {}", wwwAuthenticate);
            String[] parts = wwwAuthenticate.split(" ");
            if (parts.length == 2) {
                String authorizationType = parts[0];
                String realm = "";
                String service = "";
                String scope = "";
                for (String target : parts[1].split(",")) {
                    if (target.startsWith("realm")) {
                        realm = target.split("=")[1].replaceAll("\"", "");
                        continue;
                    }
                    if (target.startsWith("service")) {
                        service = target.split("=")[1].replaceAll("\"", "");
                        continue;
                    }
                    if (target.startsWith("scope")) {
                        scope = target.split("=")[1].replaceAll("\"", "");
                        continue;
                    }
                }
                return Optional.of(new AuthorizationContext(authorizationType, realm, service, scope, client));
            }
            throw new RuntimeException("unable to handle authentication method");
        }
        return Optional.empty();
    }

}