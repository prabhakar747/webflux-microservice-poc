package com.webflux.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
