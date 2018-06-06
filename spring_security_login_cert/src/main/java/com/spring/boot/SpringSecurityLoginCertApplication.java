package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@SpringBootApplication(scanBasePackages = {"com.spring.boot.config", "com.spring.boot.demo.controller"})
@EnableWebSecurity
//@ComponentScan(basePackages = {"com.spring.boot.config", "com.spring.boot.demo.controller"})
public class SpringSecurityLoginCertApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//return application.sources(SpringSecurityLoginCertApplication.class);
		return super.configure(application);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLoginCertApplication.class, args);
	}
}
