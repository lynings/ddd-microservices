package pers.lyning.springcloud.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author lyning
 */
public class AuthenticationException extends ResponseStatusException {

    private AuthenticationException(HttpStatus httpStatus, String errorMsg) {
        super(httpStatus, errorMsg);
    }

    public static AuthenticationException throwUnauthorized() {
        return new AuthenticationException(HttpStatus.UNAUTHORIZED, "未认证");
    }

    public static AuthenticationException throwForbidden() {
        return new AuthenticationException(HttpStatus.FORBIDDEN, "认证失败");
    }
}
