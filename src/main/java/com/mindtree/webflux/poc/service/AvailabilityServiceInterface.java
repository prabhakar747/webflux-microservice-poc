/**
 * 
 */
package com.mindtree.webflux.poc.service;

import com.mindtree.webflux.poc.model.Availability;
import com.mindtree.webflux.poc.model.Reservation;
import com.mindtree.webflux.poc.valueobjects.AvailabilityVO;

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
