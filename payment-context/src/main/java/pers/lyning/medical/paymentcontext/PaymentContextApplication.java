package pers.lyning.medical.paymentcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lyning
 */
@SpringBootApplication
@EnableWebFlux
public class PaymentContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentContextApplication.class, args);
    }
}
