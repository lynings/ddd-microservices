package pers.lyning.medical.patientcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.config.EnableWebFlux;

//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableWebFlux
@EnableJpaAuditing
public class PatientContextApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PatientContextApplication.class, args);
    }
}
