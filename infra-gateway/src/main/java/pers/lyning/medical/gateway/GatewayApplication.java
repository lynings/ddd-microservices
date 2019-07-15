package pers.lyning.medical.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableWebFlux
public class GatewayApplication {

    public static void main(final String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
