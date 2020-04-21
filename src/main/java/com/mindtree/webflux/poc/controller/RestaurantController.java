/**
 * 
 */
package com.mindtree.webflux.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.webflux.poc.model.Restaurant;
import com.mindtree.webflux.poc.service.RestaurantService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.mindtree.webflux.poc.constants.RestaurantBookingConstants;

/**
 * @author prabhakar
 *
 */
@RestController
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" }) // This is to integrate React and Angular client applications
@Slf4j
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	Logger logger = LoggerFactory.getLogger(RestaurantController.class);

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
		logger.error("Exception caught in handleRuntimeException :  {} ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}
	
	/**
	 * This method to create a Restaurant
	 * @param restaurant
	 * @return
	 */
	@PostMapping(RestaurantBookingConstants.RESTAURANT_CREATE_END_POINT_V1)
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
		if (logger.isDebugEnabled()) {
			logger.debug("Request received for createRestaurant {}", restaurant.toString());
		}
		return restaurantService.createRestaurant(restaurant);

	}
	
	/**
	 * This method to fetch a Restaurant based on Restaurant ID
	 * @param id
	 * @return 
	 */
	@GetMapping(RestaurantBookingConstants.RESTAURANT_END_POINT_V1 + "/{id}")
	public Mono<ResponseEntity<Restaurant>> getRestaurantById(@PathVariable String id) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for getRestaurantById {}", id);
		}

		return restaurantService.getRestaurantById(id)
				.map((restaurant) -> new ResponseEntity<>(restaurant, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND));

	}
	
	/**
	 * This method to handle to get the all restaurants
	 * @return
	 */
	@GetMapping(RestaurantBookingConstants.RESTAURANTS_END_POINT_V1)
	public Flux<Restaurant> getAllRestaurants() {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for getAllRestaurants");
		}
		return restaurantService.getRestaurants();
	}
	
	/**
	 * This method to handle updating a Restaurant based on Restaurant ID
	 * @param restaurant
	 * @param id
	 * @return
	 */
	@PutMapping(RestaurantBookingConstants.RESTAURANT_END_POINT_V1+ "/{id}")
	public Mono<ResponseEntity<Restaurant>> updateRestaurant(@RequestBody Restaurant restaurant,
			@PathVariable String id) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for updateRestaurant");
		}
		return restaurantService.updateRestaurant(restaurant, id)
				.map(updatedRestaurant -> new ResponseEntity<>(updatedRestaurant, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}
	
	/**
	 * This method to handle deleting a Restaurant based on Restaurant ID
	 * @param id
	 * @return
	 */
	@DeleteMapping(RestaurantBookingConstants.RESTAURANT_END_POINT_V1+ "/{id}")
	public Mono<Void> deleteRestaurant(@PathVariable String id){
		return restaurantService.deleteRestaurant(id);
	}
	
	
	/**
	 * This method to fetch a Restaurant based on Restaurant ID
	 * @param id
	 * @return 
	 */
	@GetMapping(RestaurantBookingConstants.RESTAURANTS_SEARCH_BY_NAME_END_POINT_V1 + "/{cityName}")
	public Flux<Restaurant> getRestaurantsByName(@PathVariable String cityName) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for getRestaurantsByName {}", cityName);
		}

		return restaurantService.findByName(cityName);
				
	}
	
	/**
	 * This method to fetch a tables of a restaurant based on Restaurant ID
	 * @param id
	 * @return 
	 */
/*	@GetMapping(RESTAURANT_END_POINT_V1 + "/{id}/tables")
	public Flux<Table> getRestaurantTables(@PathVariable String id) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for getRestaurantTables {}", id);
		}

		return restaurantService.getRestaurantById(id).flatMapMany(restaurantService -> {
			
		});
	}*/

}
