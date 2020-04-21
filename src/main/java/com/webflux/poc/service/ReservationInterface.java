/**
 * 
 */
package com.webflux.poc.service;

import com.webflux.poc.model.Reservation;
import com.webflux.poc.valueobjects.ReservationVO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
public interface ReservationInterface {

	public Flux<Reservation> getReservations();
	public Mono<Reservation> getReservationById(String id);
	public Mono<Reservation> createReservation(ReservationVO reservationVO);
	public Mono<Reservation> updateReservation(ReservationVO reservationVO, String id);
	public Mono<Void> deleteReservation(String id);
	
	
}
