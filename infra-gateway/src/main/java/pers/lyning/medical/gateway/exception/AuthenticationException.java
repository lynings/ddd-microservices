package pers.lyning.medical.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author lyning
 */
public class AuthenticationException extends ResponseStatusException {

    private static final long serialVersionUID = -3913080873451211952L;

    private AuthenticationException(final HttpStatus httpStatus, final String errorMsg) {
        super(httpStatus, errorMsg);
    }

    public static AuthenticationException throwForbidden() {
        return new AuthenticationException(HttpStatus.FORBIDDEN, "认证失败");
    }

    public static AuthenticationException throwUnauthorized() {
        return new AuthenticationException(HttpStatus.UNAUTHORIZED, "未认证");
    }
}
