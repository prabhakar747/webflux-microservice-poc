/**
 * 
 */
package com.webflux.poc.service;

import com.webflux.poc.model.Restaurant;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
public interface RestaurantInterface {

	public Flux<Restaurant> getRestaurants();
	public Mono<Restaurant> getRestaurantById(String id);
	public Mono<Restaurant> createRestaurant(Restaurant restaurant);
	public Mono<Restaurant> updateRestaurant(Restaurant restaurant, String id);
	public Mono<Void> deleteRestaurant(String id);
	public Flux<Restaurant> findByName(String city);
	/* public Flux<Table> getRestaurantTables(String id); */
	
	
}
