package pers.lyning.springcloud.gateway.filter;

import io.jsonwebtoken.JwtHandlerAdapter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author lyning
 */
@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    public String secret;
    public final static String TOKEN_PREFIX = "BEARER";
    public final static String HEADER = "Authorization";

    public String generate(User user) {
        String jwt = this.generateJwt(user);
        return TOKEN_PREFIX + " " + jwt;
    }

    private String generateJwt(User user) {
        return Jwts.builder()
                .setClaims(user.asMap())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }

    public Optional<User> validate(String token) {
        return Optional.ofNullable(token)
                .map(this::toUser);
    }

    private User toUser(String token) {
        return Jwts.parser()
                .setSigningKey(this.secret)
                .parse(token.replace(TOKEN_PREFIX, ""), new JwtHandlerAdapter<User>() {
                });
    }
}
