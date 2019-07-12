package pers.lyning.springcloud.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import pers.lyning.springcloud.gateway.exception.AuthenticationException;
import pers.lyning.springcloud.gateway.oss.JwtProvider;
import pers.lyning.springcloud.gateway.oss.Token;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 认证 filter
 *
 * @author lyning
 */
@Configuration
public class AuthenticationFilter implements GlobalFilter {

    private static final List<String> IGNORE_URI = Arrays.asList(
            "/tokens"
    );

    private final JwtProvider jwtProvider;

    @Autowired
    public AuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (this.ignoreRequest(this.getRoute(exchange))) {
            return chain.filter(exchange);
        }

        Token token = this.lookupTokenFrom(exchange.getRequest().getHeaders());
        this.validate(token);
        return chain.filter(exchange);
    }

    private void validate(Token token) {
        if (Objects.isNull(token)) {
            throw AuthenticationException.throwUnauthorized();
        }

        try {
            this.jwtProvider.validate(token);
        } catch (Exception e) {
            throw AuthenticationException.throwForbidden();
        }
    }

    private boolean ignoreRequest(Route route) {
        String host = this.findHostFrom(route);
        // 只要包含 被匹配到的 uri，就返回 true
        return IGNORE_URI.stream()
                .anyMatch(host::endsWith);
    }

    private Route getRoute(ServerWebExchange exchange) {
        return exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
    }

    private Token lookupTokenFrom(HttpHeaders headers) {
        String token = headers.getFirst(JwtProvider.HEADER);
        return Optional.ofNullable(token)
                .map(Token::of)
                .orElse(null);
    }

    private String findHostFrom(Route route) {
        return route.getUri()
                .getHost();
    }
}
