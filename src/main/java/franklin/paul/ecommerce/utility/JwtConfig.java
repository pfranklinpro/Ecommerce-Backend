package franklin.paul.ecommerce.utility;

import java.io.IOException;
import java.security.Key;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtConfig {
	private final int expiration = 60 * 60 * 1000;
	private final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;
	private final Key signingKey;
	private final Properties props = new Properties();
	
	public JwtConfig() {
        try {
            props.load(JwtConfig.class.getResourceAsStream("/application.properties"));
        } catch(IOException e) {
            e.printStackTrace();
        }
//        byte[] saltyBytes = DatatypeConverter.parseBase64Binary(props.getProperty("salt"));
//        https://www.baeldung.com/java-base64-encode-and-decode
//        https://docs.oracle.com/javase/7/docs/api/javax/xml/bind/DatatypeConverter.html#parseBase64Binary(java.lang.String)
        byte[] saltyBytes = Base64.getDecoder().decode(props.getProperty("salt"));
        signingKey = new SecretKeySpec(saltyBytes, sigAlg.getJcaName());
    }

	public int getExpiration() {
        return expiration;
    }

    public SignatureAlgorithm getSigAlg() {
        return sigAlg;
    }

    public Key getSigningKey() {
        return signingKey;
    }
}
