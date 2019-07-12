package pers.lyning.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.integration.config.EnableIntegration;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableConfigServer
@EnableIntegration
public class ConfigApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
