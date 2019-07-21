package pers.lynings.medical.apmadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author lyning
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
public class ApmAdminApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ApmAdminApplication.class, args);
    }

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(final ServerHttpSecurity http) {
        http.authorizeExchange().anyExchange().permitAll()
                .and().csrf().disable();
        return http.build();
    }
}
