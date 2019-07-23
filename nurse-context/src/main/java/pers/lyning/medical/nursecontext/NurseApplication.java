package pers.lyning.medical.nursecontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableWebFlux
public class NurseApplication {

    public static void main(final String[] args) {
        SpringApplication.run(NurseApplication.class, args);
    }
}
