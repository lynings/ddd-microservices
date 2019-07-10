package pers.lyning.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(final String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
