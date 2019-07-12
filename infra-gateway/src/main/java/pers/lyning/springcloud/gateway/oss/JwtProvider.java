package pers.lyning.springcloud.gateway.oss;

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

    public Token generate(Payload payload) {
        String jwt = this.generateJwt(payload);
        return Token.fillPrefix(jwt);
    }

    public Token renew(Token token) {
        Payload payload = this.parse(token);
        return this.generate(payload);
    }

    private String generateJwt(Payload payload) {
        return Jwts.builder()
                .setClaims(payload.asMap())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }

    public void validate(Token token) {
        this.parse(token);
    }

    private Payload parse(Token token) {
        return Jwts.parser()
                .setSigningKey(this.secret)
                .parse(token.refining(), new JwtHandlerAdapter<Payload>() {
                    @Override
                    public Payload onClaimsJws(Jws<Claims> jws) {
                        return JSON.parseObject(JSON.toJSONString(jws.getBody()), Payload.class);
                    }
                });
    }
}
