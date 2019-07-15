package pers.lyning.medical.gateway.oss;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lyning
 */
@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    public String secret;
    public final static String HEADER = "Authorization";

    public Token generate(final Payload payload) {
        final String jwt = this.generateJwt(payload);
        return Token.fillPrefix(jwt);
    }

    public Token renew(final Token token) {
        final Payload payload = this.parse(token);
        return this.generate(payload);
    }

    private String generateJwt(final Payload payload) {
        return Jwts.builder()
                .setClaims(payload.asMap())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }

    public void validate(final Token token) {
        this.parse(token);
    }

    private Payload parse(final Token token) {
        return Jwts.parser()
                .setSigningKey(this.secret)
                .parse(token.refining(), new JwtHandlerAdapter<Payload>() {
                    @Override
                    public Payload onClaimsJws(final Jws<Claims> jws) {
                        return JSON.parseObject(JSON.toJSONString(jws.getBody()), Payload.class);
                    }
                });
    }
}
