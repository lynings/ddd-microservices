package pers.lyning.springcloud.gateway.handler;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

/**
 * @author lyning
 */
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request,
                                                  boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(
                request, includeStackTrace);
        map.put("status", HttpStatus.BAD_REQUEST.value());
        map.put("message", "username is required");
        return map;
    }
}
