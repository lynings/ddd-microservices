package pers.lyning.medical.gateway.exception.handler;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.all;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 统一异常处理
 *
 * @author lyning
 */
@Configuration
@Order(-2)
public class GlobalErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

    public GlobalErrorWebExceptionHandler(final ErrorAttributes errorAttributes,
                                          final ApplicationContext applicationContext,
                                          final ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, new ResourceProperties(), new ErrorProperties(), applicationContext);
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        super.setMessageReaders(serverCodecConfigurer.getReaders());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(final ErrorAttributes errorAttributes) {
        return route(all(), this::renderErrorResponse);
    }
}