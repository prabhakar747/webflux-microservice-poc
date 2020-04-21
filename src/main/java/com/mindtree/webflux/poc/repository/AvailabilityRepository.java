/**
 * 
 */
package com.mindtree.webflux.poc.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mindtree.webflux.poc.model.Availability;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
public interface AvailabilityRepository extends ReactiveMongoRepository<Availability, String> {
	


	@Query("{'city':?0 , 'forDate' :?1, 'available': { $gt : 0 }}")
	Flux<Availability> availabilitySearch(String city,Date date);
	
	@Query("{'city':?0, 'available' : { $gt : 0 }}")
	Flux<Availability> citySearch(String city);	
	
	@Query("{'forDate' :?0, 'available' : { $gt : 0 } }")
	Flux<Availability> dateSearch(Date date);	
	
	
	
	@Query("{'restaurantId':?0}")
	Mono<Availability> findByResIdAndDate(String restaurantId);


}
