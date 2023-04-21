package franklin.paul.ecommerce.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import franklin.paul.ecommerce.dtos.responses.Principal;
import franklin.paul.ecommerce.utility.JwtConfig;

@Service
public class EcommerceTokenService {
	private final JwtConfig jwtConfig;
	
	public EcommerceTokenService(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}
	
    public String createNewToken(Principal subject) {
        long now = System.currentTimeMillis();

        JwtBuilder tokenBuilder = Jwts.builder()
                .setId(subject.getUserId())
                .setIssuer("Ecommerce")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()))
                .setSubject(subject.getUsername())
                .claim("country", subject.getCountry())
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());

        String token = tokenBuilder.compact();
        subject.setToken(token);
        return token;
    }

    public Principal retrievePrincipalFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Not Authorized");
        }

        Principal principal = new Principal(
                claims.getId(),
                claims.getSubject(),
                claims.get("country", String.class)
        );
        principal.setToken(token);
        return principal;
    }
}
