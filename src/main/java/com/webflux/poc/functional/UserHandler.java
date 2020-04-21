/**
 * 
 */
package com.webflux.poc.functional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webflux.poc.constants.RestaurantBookingConstants;
import com.webflux.poc.model.User;
import com.webflux.poc.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author prabhakar
 *
 */
@Component
@Slf4j
public class UserHandler {
	
	@Autowired
	UserRepository userRepository;
	
	
	public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest){
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(userRepository.findAll(), User.class);
	}
	
	
	public Mono<ServerResponse> getUserById(ServerRequest serverRequest){
		
		String user_id = serverRequest.pathVariable(RestaurantBookingConstants.ID);
		System.out.println("id:"+user_id);
		Mono<User> userMono = userRepository.findById(user_id);
		
		return userMono.flatMap(user ->
				ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(fromObject(user)));
		
		
	}

}
