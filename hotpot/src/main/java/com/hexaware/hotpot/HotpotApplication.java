package com.hexaware.hotpot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hexaware.hotpot.repository")
@EntityScan(basePackages = "com.hexaware.hotpot.models")
@ComponentScan(basePackages = "com.hexaware.hotpot")
public class HotpotApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotpotApplication.class, args);
    }
}