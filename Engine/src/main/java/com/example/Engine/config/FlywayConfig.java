package com.example.Engine.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        return Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3307/hotel", "root", "root")
                .schemas("hotel")
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();
    }
}
