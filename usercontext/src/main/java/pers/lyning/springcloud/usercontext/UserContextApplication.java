package pers.lyning.springcloud.usercontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableWebFlux
//@EnableJpaAuditing
public class UserContextApplication {

    public static void main(final String[] args) {
        SpringApplication.run(UserContextApplication.class, args);
    }
}
