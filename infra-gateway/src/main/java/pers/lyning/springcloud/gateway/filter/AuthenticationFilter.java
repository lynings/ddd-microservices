package pers.lyning.springcloud.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import pers.lyning.springcloud.gateway.util.UserPermissionUtil;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author lyning
 */
@Configuration
public class AuthFilter implements GlobalFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Optional<String> token = this.lookupTokenFrom(exchange.getRequest().getHeaders());
        if (!token.isPresent()) {
            return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
        }

        if (!UserPermissionUtil.verify(user, request)) {
            throw new PermissionException("no permission access service, please check");
        }


        Optional<User> userOptional = this.jwtProvider.validate(token.get());
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

    private Optional<String> lookupTokenFrom(HttpHeaders headers) {
        String token = headers.getFirst(JwtProvider.HEADER);
        return Optional.ofNullable(token);
    }

    private String findHostFrom(Route route) {
        return route.getUri()
                .getHost();
    }
}
