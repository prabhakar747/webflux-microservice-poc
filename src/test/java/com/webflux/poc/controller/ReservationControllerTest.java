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
import com.webflux.poc.model.Reservation;
import com.webflux.poc.model.Restaurant;
import com.webflux.poc.model.Table;
import com.webflux.poc.repository.ReservationRepository;

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
public class ReservationControllerTest {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	ReservationRepository reservationRepository;
	
	
	Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Before
	public void setUp() {
		logger.debug("Before*********************************");
		reservationRepository.deleteAll().thenMany(Flux.fromIterable(initializeReservations()))
				.flatMap(reservationRepository::save).doOnNext((res -> {
					System.out.println("Reservation is inserted: " + res);
				})).blockLast();
	}

	public List<Reservation> initializeReservations() {
		List<Reservation> reservations = new ArrayList<Reservation>();

		for (int i = 1; i <= 3; i++) {
			Reservation reservation = new Reservation();
			if(i==3) {reservation.setReservationId("ID_TO_DELETE");}
			reservation.setRestaurantId("RESERVATION_"+i);
			reservation.setBookedBy("BOOKED_BY"+i);
			reservation.setReservationDate(new Date());
			reservation.setTotalNumberOfPeople(5);
			reservations.add(reservation);
		}
		return reservations;
	}

	

	@Test
	public void getAllReservations() {
		logger.debug("TestCase run getAllReservations");
		webTestClient.get().uri(RestaurantBookingConstants.RESERVATIONS_END_POINT_V1).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBodyList(Restaurant.class).hasSize(3);
	}

	@Test
	public void getAllReservations_two() {
		logger.debug("TestCase run getAllReservations_two");
		webTestClient.get().uri(RestaurantBookingConstants.RESERVATIONS_END_POINT_V1).exchange().expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON).expectBodyList(Restaurant.class).hasSize(3)
				.consumeWith((response) -> {
					List<Restaurant> restaurants = response.getResponseBody();
					restaurants.forEach((res) -> {
						assertTrue(res.getRestaurantId() != null);
					});
				});
	}
	
	  @Test
	    public void createReservation(){
		  logger.debug("TestCase run createReservation");
		  Reservation res = new Reservation(null, "RESERVATION_4", new Date(),"Pinkmen",5);
	        webTestClient.post().uri(RestaurantBookingConstants.RESERVATION_CREATE_END_POINT_V1)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(Mono.just(res), Restaurant.class)
	                .exchange()
	                .expectStatus().isCreated()
	                .expectBody()
	                .jsonPath("$.reservationId").isNotEmpty()
	                .jsonPath("$.restaurantId").isEqualTo("RESERVATION_4")
	                .jsonPath("$.bookedBy").isEqualTo("Pinkmen");
	    }
	  
	    @Test
	    public void deleteReservation(){
	    	logger.debug("TestCase run deleteReservation");
	        webTestClient.delete().uri(RestaurantBookingConstants.RESERVATION_END_POINT_V1.concat("/{id}"),"ID_TO_DELETE")
	                .accept(MediaType.APPLICATION_JSON)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody(Void.class);

	    }
	    
	    
	    @Test
	    public void updateReservation(){
	    	logger.debug("TestCase run updateReservation");
	    	Reservation res = new Reservation(null, "RESERVATION_ID_UPDATE", new Date(),"Pinkmen",5);
	        webTestClient.put().uri(RestaurantBookingConstants.RESERVATION_END_POINT_V1.concat("/{id}"),"ID_TO_DELETE")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .body(Mono.just(res), Restaurant.class)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody()
	                .jsonPath("$.restaurantId","RESERVATION_ID_UPDATE");
	    }
	    
	    @Test
	    public void updateReservation_notFound(){
	    	logger.debug("TestCase run updateReservation_notFound");
	    	Reservation res = new Reservation(null, "RESERVATION_ID_UPDATE", new Date(),"Pinkmen",5);

	        webTestClient.put().uri(RestaurantBookingConstants.RESERVATION_END_POINT_V1.concat("/{id}"),"dummy")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .body(Mono.just(res), Restaurant.class)
	                .exchange()
	                .expectStatus().isNotFound();
	                
	    }

}
