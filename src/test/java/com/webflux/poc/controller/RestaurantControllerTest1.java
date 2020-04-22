package com.webflux.poc.controller;
/**
 * 
 */

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.webflux.poc.constants.RestaurantBookingConstants;
import com.webflux.poc.model.Restaurant;
import com.webflux.poc.model.Table;
import com.webflux.poc.repository.RestaurantRepository;

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
public class RestaurantControllerTest1 {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	RestaurantRepository restaurantRepository;
	
	
	Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Before
	public void setUp() {
		logger.debug("Before*********************************");
		restaurantRepository.deleteAll().thenMany(Flux.fromIterable(initializeRestaurants()))
				.flatMap(restaurantRepository::save).doOnNext((item -> {
					System.out.println("Restaurant is inserted: " + item);
				})).blockLast();
	}

	public List<Restaurant> initializeRestaurants() {
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();

		for (int i = 1; i <= 3; i++) {
			Restaurant restaurant = new Restaurant();
			if(i==3) {restaurant.setRestaurantId("ID_TO_DELETE");}
			restaurant.setCity("City_" + i);
			restaurant.setRestaurantName("R_NAME_" + i);
			restaurant.setTables(initializeTables());
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}

	public List<Table> initializeTables() {
		List<Table> tablesList = new ArrayList<Table>();

		for (int i = 1; i <= 5; i++) {
			Table table = new Table();
			table.setBookingDate(new Date());
			table.setTableCapacity(5);
			tablesList.add(table);
		}

		return tablesList;
	}

	

	@Test
	public void getAllRestaurants() {
		logger.debug("TestCase run getAllRestaurants");
		webTestClient.get().uri(RestaurantBookingConstants.RESTAURANTS_END_POINT_V1).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBodyList(Restaurant.class).hasSize(3);
	}

	@Test
	public void getAllRestaurants_two() {
		logger.debug("TestCase run getAllRestaurants_two");
		webTestClient.get().uri(RestaurantBookingConstants.RESTAURANTS_END_POINT_V1).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBodyList(Restaurant.class).hasSize(3)
				.consumeWith((response) -> {
					List<Restaurant> restaurants = response.getResponseBody();
					restaurants.forEach((res) -> {
						assertTrue(res.getRestaurantId() != null);
					});
				});
	}
	
	  @Test
	    public void createRestaurant(){
		  logger.debug("TestCase run createRestaurant");
		  Restaurant res = new Restaurant(null, "Res_3", "Gaithresburg",initializeTables());
	        webTestClient.post().uri(RestaurantBookingConstants.RESTAURANT_CREATE_END_POINT_V1)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(Mono.just(res), Restaurant.class)
	                .exchange()
	                .expectStatus().isCreated()
	                .expectBody()
	                .jsonPath("$.restaurantId").isNotEmpty()
	                .jsonPath("$.restaurantName").isEqualTo("Res_3")
	                .jsonPath("$.city").isEqualTo("Gaithresburg");
	    }
	  
	    @Test
	    public void deleteRestaurant(){
	    	logger.debug("TestCase run deleteRestaurant");
	        webTestClient.delete().uri(RestaurantBookingConstants.RESTAURANT_END_POINT_V1.concat("/{id}"),"ID_TO_DELETE")
	                .accept(MediaType.APPLICATION_JSON)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody(Void.class);

	    }
	    
	    
	    @Test
	    public void updateRestaurant(){
	    	logger.debug("TestCase run updateRestaurant");
	    	Restaurant res = new Restaurant("ID_Res_Update", "Res_Update", "Gaithresburg",initializeTables());

	        webTestClient.put().uri(RestaurantBookingConstants.RESTAURANT_END_POINT_V1.concat("/{id}"),"ID_TO_DELETE")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .body(Mono.just(res), Restaurant.class)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody()
	                .jsonPath("$.restaurantName","Res_Update");
	    }
	    
	    @Test
	    public void updateRestaurant_notFound(){
	    	logger.debug("TestCase run updateRestaurant_notFound");
	    	Restaurant res = new Restaurant("ID_Res_Update", "Res_Update", "Gaithresburg",initializeTables());

	        webTestClient.put().uri(RestaurantBookingConstants.RESTAURANT_END_POINT_V1.concat("/{id}"),"dummy")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .body(Mono.just(res), Restaurant.class)
	                .exchange()
	                .expectStatus().isNotFound();
	                
	    }

}
