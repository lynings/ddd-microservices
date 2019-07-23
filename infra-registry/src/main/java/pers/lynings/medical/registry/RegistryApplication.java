package pers.lynings.medical.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {
    public static void main(final String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }
}
