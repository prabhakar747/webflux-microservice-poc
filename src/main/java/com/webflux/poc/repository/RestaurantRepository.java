/**
 * 
 */
package com.webflux.poc.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webflux.poc.model.Restaurant;

import reactor.core.publisher.Flux;

/**
 * @author prabhakar
 *
 */
public interface RestaurantRepository  extends ReactiveMongoRepository<Restaurant, String> {

	
	@Query("{'city':?0}")
	Flux<Restaurant> findByName(String city);
	
	 
	/*
	 * @Query("{'id':?0}") Flux<Table> getRestaurantTables(String id);
	 */
}
