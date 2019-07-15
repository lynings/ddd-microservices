package pers.lyning.springcloud.patientcontext.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * flyway cfg
 *
 * @author Blink
 */
@Configuration
public class FlywayConfiguration {

    /**
     * Override default flyway initializer to do nothing
     */
    @Bean
    FlywayMigrationInitializer flywayInitializer(final Flyway flyway) {
        return new FlywayMigrationInitializer(flyway, (f) -> {
        });
    }

    /**
     * Create a second flyway initializer to run after jpa has created the schema
     */
    @Bean
    @DependsOn("entityManagerFactory")
    FlywayMigrationInitializer delayedFlywayInitializer(final Flyway flyway) {
        return new FlywayMigrationInitializer(flyway, null);
    }
}
