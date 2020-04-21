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

import com.mindtree.webflux.poc.model.Reservation;
import com.mindtree.webflux.poc.service.AvailabilityService;
import com.mindtree.webflux.poc.service.ReservationService;
import com.mindtree.webflux.poc.valueobjects.ReservationVO;

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
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@Autowired
	AvailabilityService availabilityService;

	Logger logger = LoggerFactory.getLogger(ReservationController.class);

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
	@PostMapping(RestaurantBookingConstants.RESERVATION_CREATE_END_POINT_V1)
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Reservation> createReservation(@RequestBody ReservationVO reservationVO) {
		if (logger.isDebugEnabled()) {
			logger.debug("Request received for createReservation {}", reservationVO.toString());
		}
		return reservationService.createReservation(reservationVO);

	}
	
	/**
	 * This method to fetch a Reservation based on reservation ID
	 * @param id
	 * @return 
	 */
	@GetMapping(RestaurantBookingConstants.RESERVATION_END_POINT_V1 + "/{id}")
	public Mono<ResponseEntity<Reservation>> getReservationById(@PathVariable String id) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for getReservationById {}", id);
		}

		return reservationService.getReservationById(id)
				.map((reservation) -> new ResponseEntity<>(reservation, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND));

	}
	
	/**
	 * This method to handle to get the all reservations
	 * @return
	 */
	@GetMapping(RestaurantBookingConstants.RESERVATIONS_END_POINT_V1)
	public Flux<Reservation> getAllReservations() {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for getAllReservations");
		}
		return reservationService.getReservations();
	}
	
	/**
	 * This method to handle updating a Reservation based on reservation ID
	 * @param restaurant
	 * @param id
	 * @return
	 */
	@PutMapping(RestaurantBookingConstants.RESERVATION_END_POINT_V1+ "/{id}")
	public Mono<ResponseEntity<Reservation>> updateReservation(@RequestBody ReservationVO reservationVO,
			@PathVariable String id) {

		if (logger.isDebugEnabled()) {
			logger.debug("Request received for updateReservation");
		}
		return reservationService.updateReservation(reservationVO, id)
				.map(updatedReservation -> new ResponseEntity<>(updatedReservation, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND));

	}
	
	/**
	 * This method to handle deleting a Reservation based on reservation ID
	 * @param id
	 * @return
	 */
	@DeleteMapping(RestaurantBookingConstants.RESERVATION_END_POINT_V1+ "/{id}")
	public Mono<Void> deleteReservation(@PathVariable String id){
		return reservationService.deleteReservation(id);
	}
	
	
}

