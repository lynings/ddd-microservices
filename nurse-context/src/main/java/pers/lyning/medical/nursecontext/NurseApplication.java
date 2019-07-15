package pers.lyning.medical.nursecontext;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableWebFlux
public class NurseApplication {

    public static void main(final String[] args) {
        new SpringApplicationBuilder(NurseApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }
}
