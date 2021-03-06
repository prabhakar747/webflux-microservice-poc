/**
 * 
 */
package com.webflux.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.poc.constants.RestaurantBookingConstants;
import com.webflux.poc.model.Availability;
import com.webflux.poc.service.AvailabilityService;
import com.webflux.poc.service.ReservationService;
import com.webflux.poc.valueobjects.AvailabilityVO;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
@RestController
//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" }) // This is to integrate React and Angular client applications
@Slf4j
public class AvailabilityController {

	@Autowired
	ReservationService reservationService;
	
	@Autowired
	AvailabilityService availabilityService;

	Logger logger = LoggerFactory.getLogger(AvailabilityController.class);

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
		logger.error("Exception caught in handleRuntimeException :  {} ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}
	
	
	/**
	 * This method to create a Reservation
	 * @param restaurant
	 * @return
	 */
	@PostMapping(RestaurantBookingConstants.MASTER_DATA_AVAILABLITY)
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Availability> createMasterDataAvailability(@RequestBody Availability availability) {
		
		logger.debug("Request received for createMasterDataAvailability {}", availabilityService.toString());
		
		return availabilityService.createAvailabilityMasterData(availability);

	}
	
	
	/**
	 * This method to handle to get the all restaurants
	 * @return
	 */
	@GetMapping(RestaurantBookingConstants.MASTER_DATA_AVAILABILITY_END_POINT_V1)
	public Flux<Availability> getMasterDataForAvailability() {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for getAllRestaurants");
		}
		return availabilityService.getMasterDataForAvailability();
	}
	
	/**
	 * This method to handle to get the all restaurants
	 * @return
	 */
	@PostMapping(RestaurantBookingConstants.AVAILABILITY_SEARCH_END_POINT_V1)
	@ResponseStatus(HttpStatus.FOUND)
	public Flux<Availability> availabilitySearch(@RequestBody AvailabilityVO availabilityVO) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for availabilitySearch");
		}
		return availabilityService.availabilitySearch(availabilityVO);
	}
	
	
	
	
	
}

