package pers.lyning.medical.gateway.oss.helper;

import pers.lyning.medical.gateway.oss.JwtProvider;
import pers.lyning.medical.gateway.oss.Payload;
import pers.lyning.medical.gateway.oss.Token;

/**
 * @author lyning
 */
public class TokenGenerator {

    private static final long EXPIRATION = 604800L;
    private static final String SECRET = "xfk!@#$%^&*()xfk!@#$%^&*()xfk!@#$%^&*()";
    private static final long RENEW_EXPIRATION = 2592000L;

    private final static JwtProvider jwtProvider = new JwtProvider();

    static {
        jwtProvider.setSecret(SECRET);
        jwtProvider.setExpiration(EXPIRATION);
        jwtProvider.setRenewExpiration(RENEW_EXPIRATION);
    }

    public static Token generateExpiredToken() {
        final JwtProvider jwtProvider = new JwtProvider();
        jwtProvider.setSecret(SECRET);
        jwtProvider.setRenewExpiration(RENEW_EXPIRATION);
        jwtProvider.setExpiration(0L);

        final Payload givenPayload = PayloadFactory.create();
        return jwtProvider.generate(givenPayload);
    }

    public static Token generateUnexpiredToken() {
        final Payload givenPayload = PayloadFactory.create();
        return jwtProvider.generate(givenPayload);
    }
}
