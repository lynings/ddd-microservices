package pers.lyning.medical.nursingcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableWebFlux
public class NursingApplication {

    public static void main(final String[] args) {
        SpringApplication.run(NursingApplication.class, args);
    }
}
