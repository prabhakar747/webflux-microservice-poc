/**
 * 
 */
package com.webflux.poc.service;

import com.webflux.poc.model.Availability;
import com.webflux.poc.model.Reservation;
import com.webflux.poc.valueobjects.AvailabilityVO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
public interface AvailabilityServiceInterface {

	public Flux<Availability> getMasterDataForAvailability();
	public Mono<Availability> createAvailabilityMasterData(Availability availability);
	public Flux<Availability> availabilitySearch(AvailabilityVO availabilityVO);
	public void updateAvalabiltyDocument(Reservation reseravtion);
	
	public Mono<Availability> updateAvailabilityMasterData(Availability availability,String id);
	 
}
