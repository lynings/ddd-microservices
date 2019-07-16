package pers.lyning.medical.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import pers.lyning.medical.gateway.exception.AuthenticationException;
import pers.lyning.medical.gateway.oss.JwtProvider;
import pers.lyning.medical.gateway.oss.Token;
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
    public AuthenticationFilter(final JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final GatewayFilterChain chain) {
        if (this.ignoreRequest(this.getRoute(exchange))) {
            return chain.filter(exchange);
        }

        final Token token = this.lookupTokenFrom(exchange.getRequest().getHeaders());
        this.validate(token);
        return chain.filter(exchange);
    }

    private void validate(final Token token) {
        if (Objects.isNull(token)) {
            throw AuthenticationException.throwUnauthorized();
        }

        if (!this.jwtProvider.validate(token)) {
            throw AuthenticationException.throwForbidden();
        }
    }

    private boolean ignoreRequest(final Route route) {
        final String host = this.findHostFrom(route);
        // 只要包含 被匹配到的 uri，就返回 true
        return IGNORE_URI.stream()
                .anyMatch(host::endsWith);
    }

    private Route getRoute(final ServerWebExchange exchange) {
        return exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
    }

    private Token lookupTokenFrom(final HttpHeaders headers) {
        final String token = headers.getFirst(JwtProvider.HEADER);
        return Optional.ofNullable(token)
                .map(Token::of)
                .orElse(null);
    }

    private String findHostFrom(final Route route) {
        return route.getUri()
                .getHost();
    }
}
