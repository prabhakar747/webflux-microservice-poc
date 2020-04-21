package com.mindtree.webflux.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.webflux.poc.model.Availability;
import com.mindtree.webflux.poc.model.Reservation;
import com.mindtree.webflux.poc.repository.AvailabilityRepository;
import com.mindtree.webflux.poc.repository.RestaurantRepository;
import com.mindtree.webflux.poc.valueobjects.AvailabilityVO;

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
		
		
		 availabilityRepository.findByResIdAndDate("5e8cd4d31fbf087bd8581ee3")
		 .map(old -> {
			 Availability newAva = new Availability();
			 newAva.setId(old.getId());
			 newAva.setAvailable(4);
			 return newAva;
		 })
		 .flatMap(currentAvailabilityRow -> {
			System.out.println("-------------------Inside-----------------------------");
			return availabilityRepository.save(currentAvailabilityRow);
		});
		
		
		
	}

	@Override
	public Mono<Availability> updateAvailabilityMasterData(Availability availability, String id) {
		return availabilityRepository.findByResIdAndDate("5e8cd4d31fbf087bd8581ee3").flatMap(currentAvailability -> {
			currentAvailability.setAvailable(availability.getAvailable()-1);
			return availabilityRepository.save(currentAvailability);
		});
		
	}

	
}
