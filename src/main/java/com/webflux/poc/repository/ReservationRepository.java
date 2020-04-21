/**
 * 
 */
package com.webflux.poc.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webflux.poc.model.Reservation;

/**
 * @author prabhakar
 *
 */
public interface ReservationRepository  extends ReactiveMongoRepository<Reservation, String> {

}
