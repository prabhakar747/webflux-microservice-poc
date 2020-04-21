/**
 * 
 */
package com.mindtree.webflux.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.webflux.poc.model.Restaurant;
import com.mindtree.webflux.poc.repository.RestaurantRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
@Service
public class RestaurantService implements RestaurantInterface {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public Flux<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Mono<Restaurant> getRestaurantById(String id) {
		return restaurantRepository.findById(id);
				
	}

	@Override
	public Mono<Restaurant> createRestaurant(Restaurant restaurant) {
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Mono<Restaurant> updateRestaurant(Restaurant restaurant, String id) {

        return restaurantRepository.findById(id)
                .flatMap(currentRestaurant -> {
                	currentRestaurant.setRestaurantName(restaurant.getRestaurantName());
                	currentRestaurant.setCity(restaurant.getCity());
                    return restaurantRepository.save(currentRestaurant);
                });
                
	}

	@Override
	public Mono<Void> deleteRestaurant(String id) {
		return restaurantRepository.deleteById(id);
	}

	@Override
	public Flux<Restaurant> findByName(String city) {
		return restaurantRepository.findByName(city);
	}
	
	
	/*
	 * @Override public Flux<Table> getRestaurantTables(String id) { return
	 * restaurantRepository.getRestaurantTables(id);
	 * 
	 * }
	 */

}
