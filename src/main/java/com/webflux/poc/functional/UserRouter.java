package com.webflux.poc.functional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webflux.poc.constants.RestaurantBookingConstants;


@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> itemsRoute(UserHandler userHandler){

        return RouterFunctions
                .route(GET(RestaurantBookingConstants.USERS_FUNCTIONAL_END_POINT_V1).and(accept(APPLICATION_JSON))
                ,userHandler::getAllUsers)
                .andRoute(GET(RestaurantBookingConstants.USER_FUNCTIONAL_END_POINT_V1+"/{id}").and(accept(APPLICATION_JSON))
                ,userHandler::getUserById);
    }

	/*
	 * @Bean public RouterFunction<ServerResponse> errorRoute(UserHandler
	 * userHandler){ return RouterFunctions
	 * .route(GET("/fun/runtimeexception").and(accept(APPLICATION_JSON))
	 * ,userHandler::itemsEx);
	 * 
	 * }
	 * 
	 * @Bean public RouterFunction<ServerResponse> itemStreamRoute(ItemsHandler
	 * itemsHandler){
	 * 
	 * return RouterFunctions
	 * .route(GET(ITEM_STREAM_FUNCTIONAL_END_POINT_V1).and(accept(APPLICATION_JSON))
	 * ,itemsHandler::itemsStream);
	 * 
	 * }
	 */
}
