package com.kcabs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.spring.main.allow-bean-definition-overriding;
@SpringBootApplication
@ComponentScan({"com.kcabs.service","com.kcabs.dao","com.kcabs.model","com.kcabs.demo"})//to scan repository files
public class ProjApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjApplication.class, args);
		System.out.print("It's Running!");
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ProjApplication.class);
	}
}
