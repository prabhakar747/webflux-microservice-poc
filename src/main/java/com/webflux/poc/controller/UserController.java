/**
 * 
 */
package com.webflux.poc.controller;




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

import com.webflux.poc.constants.RestaurantBookingConstants;
import com.webflux.poc.model.User;
import com.webflux.poc.service.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
@RestController
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })  // This is to integrate React and Angular client applications
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        logger.error("Exception caught in handleRuntimeException :  {} " , ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
	
	/**
	 * This method to create a User 
	 * @param user
	 * @return
	 */
    @PostMapping(RestaurantBookingConstants.USER_CREATE_END_POINT_V1)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> createUser(@RequestBody User user){
    	if(logger.isDebugEnabled()) {
    		  logger.debug("Request received for createUser() {}",user.toString());
  		}
    	return userService.createUser(user);
        
    }
	
    /**
     * This method to fetch all user 	
     * @return
     */
	@GetMapping(RestaurantBookingConstants.USERS_END_POINT_V1)
    public Flux<User> getAllUsers(){
		
		if(logger.isDebugEnabled()) {
	  		  logger.debug("Request received for getAllUsers()");
		}
		return userService.getAllUsers();
       

    }
	
	/**
	 * This method to fetch user based on user ID
	 * @param id
	 * @return
	 */
    @GetMapping(RestaurantBookingConstants.USER_END_POINT_V1+"/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable String id){
    	
    	if(logger.isDebugEnabled()) {
    		  logger.debug("Request received for getUserById() {}",id);
  		}
    	return userService.getUserById(id)
    			 .map((user) -> new ResponseEntity<>(user, HttpStatus.OK))
	                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
       

    }
    
	/**
	 * This method to handle updating a User based on user ID
	 * @param user
	 * @param id
	 * @return
	 */
	@PutMapping(RestaurantBookingConstants.USER_END_POINT_V1+ "/{id}")
	public Mono<ResponseEntity<User>> updateUser(@RequestBody User user,
			@PathVariable String id) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for updateUser");
		}
		return userService.updateUser(user, id)
				.map(updatedUser -> new ResponseEntity<>(updatedUser, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}
	
	/**
	 * This method to handle deleting user based on user ID
	 * @param id
	 * @return
	 */
	@DeleteMapping(RestaurantBookingConstants.USER_END_POINT_V1+ "/{id}")
	public Mono<Void> deleteUser(@PathVariable String id){
		return userService.deleteUser(id);
	}



}
