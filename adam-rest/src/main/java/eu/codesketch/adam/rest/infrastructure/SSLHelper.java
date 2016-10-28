/**
 * 
 */
package eu.codesketch.adam.rest.infrastructure;

import com.github.dockerjava.core.SSLConfig;

import eu.codesketch.adam.docker.StringSSLConfig;

/**
 * @author quirino
 *
 */
public abstract class SSLHelper {

    public static final SSLConfig prepareSSLConfig(String ca, String key, String cert) {
        return new StringSSLConfig(ca, key, cert);
    }
}
