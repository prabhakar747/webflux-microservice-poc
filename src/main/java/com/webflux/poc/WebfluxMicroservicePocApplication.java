package com.webflux.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebfluxMicroservicePocApplication /*extends SpringBootServletInitializer*/ {

/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebfluxMicroservicePocApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(WebfluxMicroservicePocApplication.class, args);
	}

}
