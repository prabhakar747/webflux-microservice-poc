package com.webflux.poc.controller;
/**
 * 
 */

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.webflux.poc.constants.RestaurantBookingConstants;
import com.webflux.poc.model.User;
import com.webflux.poc.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class UserControllerTest {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	UserRepository userRepository;

	public List<User> data() {
		return Arrays.asList(new User(null, "Prabhakar", "Naidu", "prabha@mindrree.com", "Gaithresburg", "1234455555"),
				new User(null, "Jesse", "Pinkmen", "Jesse@mindrree.com", "Gaithresburg", "1234455555"),
				new User("BreBad", "Hank", "Schr", "hank@mindrree.com", "Gaithresburg", "1234455555"));
	}

	@Before
	public void setUp() {
		System.out.println("Before------");
		userRepository.deleteAll().thenMany(Flux.fromIterable(data())).flatMap(userRepository::save).doOnNext((item -> {
			System.out.println("Inserted User is : " + item);
		})).blockLast();
	}

	@Test
	public void getAllUsers() {
		System.out.println("TestCase run getAllUsers");
		webTestClient.get().uri(RestaurantBookingConstants.USERS_END_POINT_V1).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBodyList(User.class).hasSize(3);
	}

	@Test
	public void getAllUsers_two() {
		System.out.println("TestCase run getAllUsers_two");
		webTestClient.get().uri(RestaurantBookingConstants.USERS_END_POINT_V1).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBodyList(User.class).hasSize(3)
				.consumeWith((response) -> {
					List<User> items = response.getResponseBody();
					items.forEach((item) -> {
						assertTrue(item.getId() != null);
					});
				});
	}
	
	  @Test
	    public void createUser(){
		  System.out.println("TestCase run createUser");
		  User user = new User(null, "Jesse", "Pinkmen", "Jesse@mindrree.com", "Gaithresburg", "1234455555");
	        webTestClient.post().uri(RestaurantBookingConstants.USER_CREATE_END_POINT_V1)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(Mono.just(user), User.class)
	                .exchange()
	                .expectStatus().isCreated()
	                .expectBody()
	                .jsonPath("$.id").isNotEmpty()
	                .jsonPath("$.firstName").isEqualTo("Jesse")
	                .jsonPath("$.lastName").isEqualTo("Pinkmen");
	    }
	  
	    @Test
	    public void deleteUser(){
	    	System.out.println("TestCase run deleteUser");
	        webTestClient.delete().uri(RestaurantBookingConstants.USER_END_POINT_V1.concat("/{id}"),"BreBad")
	                .accept(MediaType.APPLICATION_JSON)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody(Void.class);

	    }
	    
	    
	    @Test
	    public void updateUser(){
	    	System.out.println("TestCase run updateUser");
	        User user = new User(null, "JesseUpdatd", "Pinkmen", "Jesse@mindrree.com", "Gaithresburg", "1234455555");

	        webTestClient.put().uri(RestaurantBookingConstants.USER_END_POINT_V1.concat("/{id}"),"BreBad")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .body(Mono.just(user), User.class)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody()
	                .jsonPath("$.firstName","JesseUpdatd");
	    }
	    
	    @Test
	    public void updateUser_notFound(){
	    	System.out.println("TestCase run updateUser_notFound");
	        User user = new User(null, "JesseUpdatd", "Pinkmen", "Jesse@mindrree.com", "Gaithresburg", "1234455555");

	        webTestClient.put().uri(RestaurantBookingConstants.USER_END_POINT_V1.concat("/{id}"),"NotFound")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .body(Mono.just(user), User.class)
	                .exchange()
	                .expectStatus().isNotFound();
	    }

}
