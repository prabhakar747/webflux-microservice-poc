package com.mindtree.webflux.poc.functional;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AppRoute {

	@Bean
	public RouterFunction<ServerResponse> route(FormHandler formHandler) {

		return RouterFunctions.route()
				.GET("/form", formHandler::sampleForm)
				.POST("/form", accept(MediaType.APPLICATION_FORM_URLENCODED), formHandler::displayFormData)
				.build();
	}
}
