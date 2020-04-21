/**
 * 
 */
package com.mindtree.webflux.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mindtree.webflux.poc.model.User;

/**
 * @author prabhakar
 *
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {
	
	
	List<User> findByFirstName(final String firstName);

	  @Query("{'city': ?0}")
	  List<User> findByCity(final String city);
	

}
