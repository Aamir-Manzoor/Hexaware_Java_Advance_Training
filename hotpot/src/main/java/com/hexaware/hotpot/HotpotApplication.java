package com.hexaware.hotpot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hexaware.hotpot.repository")
@EntityScan(basePackages = "com.hexaware.hotpot.models")
@ComponentScan(basePackages = "com.hexaware.hotpot")
public class HotpotApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HotpotApplication.class, args);
	}
	
	@Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}