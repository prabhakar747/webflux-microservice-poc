/**
 * 
 */
package com.mindtree.webflux.poc.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mindtree.webflux.poc.model.Reservation;

/**
 * @author prabhakar
 *
 */
public interface ReservationRepository  extends ReactiveMongoRepository<Reservation, String> {

}
