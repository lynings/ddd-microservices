package pers.lyning.springcloud.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author lyning
 */
@Component
public class AuthFilter implements GlobalFilter {

    private final JwtProvider jwtProvider;

    @Autowired
    public AuthFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = this.findTokenFrom(exchange.getRequest().getHeaders());
        Optional<User> userOptional = this.jwtProvider.validate(token);
        ServerHttpRequest request = userOptional
                .map(user -> this.createServerHttpRequest(exchange, user))
                .orElseThrow(() -> new PermissionException("user not exist, please check"));
        return chain.filter(exchange.mutate().request(request).build());
    }

    private ServerHttpRequest createServerHttpRequest(ServerWebExchange exchange, User user) {
        return exchange.getRequest()
                .mutate()
                .header("x-user-id", user.getId().toString())
                .header("x-username", user.getUsername())
                .header("x-user-serviceName", this.findHostFrom(this.getRoute(exchange)))
                .build();
    }

    private Route getRoute(ServerWebExchange exchange) {
        return exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
    }

    private String findTokenFrom(HttpHeaders headers) {
        return headers.getFirst(JwtProvider.HEADER);
    }

    private String findHostFrom(Route route) {
        return route.getUri()
                .getHost();
    }
}
