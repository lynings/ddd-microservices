package pers.lyning.springcloud.usercontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserContextApplication {

    public static void main(final String[] args) {
        SpringApplication.run(UserContextApplication.class, args);
    }
}
