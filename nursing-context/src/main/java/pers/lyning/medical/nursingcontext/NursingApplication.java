package pers.lyning.medical.nursingcontext;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableWebFlux
public class NursingApplication {

    public static void main(final String[] args) {
        new SpringApplicationBuilder(NursingApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }
}
