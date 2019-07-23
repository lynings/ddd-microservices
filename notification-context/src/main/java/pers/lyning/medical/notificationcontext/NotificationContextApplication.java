package pers.lyning.medical.notificationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableWebFlux
public class NotificationContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationContextApplication.class, args);
    }
}
