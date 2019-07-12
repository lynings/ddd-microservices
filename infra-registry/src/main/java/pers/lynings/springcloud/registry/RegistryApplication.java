package pers.lynings.springcloud.registry;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {
    public static void main(final String[] args) {
        new SpringApplicationBuilder(RegistryApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
