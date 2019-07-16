package pers.lyning.medical.gateway.oss;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lyning
 */
@Component
@Setter
@Slf4j
public class JwtProvider {

    public final static String HEADER = "Authorization";
    /**
     * 过期时间
     */
    @Value("${jwt.expiration}")
    public Long expiration;
    /**
     * 密钥
     */
    @Value("${jwt.secret}")
    public String secret;
    /**
     * 续约时长
     */
    @Value("${jwt.renew-expiration}")
    public Long renewExpiration;

    public Token generate(final Payload payload) {
        final String jwt = this.generateJwt(payload, this.expiration);
        return Token.fillPrefix(jwt);
    }

    public Payload parse(final Token token) {
        return Jwts.parser()
                .setSigningKey(this.secret)
                .parse(token.refining(), new JwtHandlerAdapter<Payload>() {
                    @Override
                    public Payload onClaimsJws(final Jws<Claims> jws) {
                        return JSON.parseObject(JSON.toJSONString(jws.getBody()), Payload.class);
                    }
                });
    }

    /**
     * 延长期限
     *
     * @param token
     * @return
     */
    public Token renew(final Token token) {
        final Payload payload = this.parse(token);
        final String jwt = this.generateJwt(payload, this.renewExpiration);
        return Token.fillPrefix(jwt);
    }

    public boolean validate(final Token token) {
        try {
            this.parse(token);
        } catch (final Exception e) {
            log.warn("token {} 验证失败", token.getToken(), e);
            return false;
        }
        return true;
    }

    private Date generateExpirationDate(final Long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private String generateJwt(final Payload payload, final Long expiration) {
        return Jwts.builder()
                .setClaims(payload.asMap())
                .setIssuedAt(new Date())
                .setExpiration(this.generateExpirationDate(expiration))
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }
}
