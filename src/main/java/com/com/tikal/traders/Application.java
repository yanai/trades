package com.com.tikal.traders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
	
	public static void main(String[] args) {

//		ConfigurableApplicationContext context = SpringApplication.run(Application.class);
		SpringApplication.run(Application.class, args);

//		context.close();
	}

	
}
