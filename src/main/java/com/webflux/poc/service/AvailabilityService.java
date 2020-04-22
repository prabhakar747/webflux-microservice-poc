package com.webflux.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webflux.poc.model.Availability;
import com.webflux.poc.model.Reservation;
import com.webflux.poc.repository.AvailabilityRepository;
import com.webflux.poc.repository.RestaurantRepository;
import com.webflux.poc.valueobjects.AvailabilityVO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
@Service
public class AvailabilityService implements AvailabilityServiceInterface{
	
	@Autowired
	AvailabilityRepository availabilityRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;



	@Override
	public Mono<Availability> createAvailabilityMasterData(Availability availability) {
	
		return availabilityRepository.save(availability);
	}
	
	@Override
	public Flux<Availability> getMasterDataForAvailability() {
		return availabilityRepository.findAll();
	}

	@Override
	public Flux<Availability> availabilitySearch(AvailabilityVO availabilityVO) {
		Flux<Availability> availabilityFlux = null;
		if(null != availabilityVO.getCity() && null != availabilityVO.getForDate()) {
			availabilityFlux = availabilityRepository.availabilitySearch(availabilityVO.getCity(),availabilityVO.getForDate());
		}else if(null != availabilityVO.getCity()){
			availabilityFlux =availabilityRepository.citySearch(availabilityVO.getCity());
		}else if(null != availabilityVO.getCity() ){
			availabilityFlux =availabilityRepository.dateSearch(availabilityVO.getForDate());
		}
		
		return availabilityFlux;
	}

	@Override
	public void updateAvalabiltyDocument(Reservation reservation) {
		
		
		 availabilityRepository.findByResIdAndDate(reservation.getRestaurantId(),reservation.getReservationDate())
		 .map(old -> {
			 Availability newAva = new Availability();
			 newAva.setId(old.getId());
			 newAva.setAvailable(old.getAvailable()-1);
			 return newAva;
		 })
		 .flatMap(currentAvailabilityRow -> {
			return availabilityRepository.save(currentAvailabilityRow);
		});
		
		
		
	}

	

	
}
