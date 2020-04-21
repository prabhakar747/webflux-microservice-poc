/**
 * 
 */
package com.mindtree.webflux.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.webflux.poc.model.Availability;
import com.mindtree.webflux.poc.model.Reservation;
import com.mindtree.webflux.poc.repository.ReservationRepository;
import com.mindtree.webflux.poc.valueobjects.ReservationVO;
import com.mindtree.webflux.poc.ws.mappers.ReservationMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
@Service
public class ReservationService implements ReservationInterface {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	ReservationMapper reservationMapper;
	
	@Autowired
	AvailabilityService availabilityService;

	@Override
	public Flux<Reservation> getReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public Mono<Reservation> getReservationById(String id) {
		return reservationRepository.findById(id);

	}

	@Override
	public Mono<Reservation> createReservation(ReservationVO reservationVO) {
		 //Covert VO object to Model object and then pass to repository layer.
		
		 // Mono<Reservation> resMono = reservationRepository.save(reservationMapper.convertToDocument(reservationVO));
		  //resMono.map(res -> {return updateAvalabiltyDocument(res);});
		  //resMono.subscribe(res -> updateAvalabiltyDocument(res));
		  //updateAvalabiltyDocument(reservationVO);
		  return reservationRepository.save(reservationMapper.convertToDocument(reservationVO)).flatMap(res -> {updateAvalabiltyDocument(res);return Mono.justOrEmpty(res);});
		 
		 
	}
	
	private void updateAvalabiltyDocument(Reservation reservation) {
		 availabilityService.updateAvalabiltyDocument(reservation);
	}

	@Override
	public Mono<Void> deleteReservation(String id) {
		return reservationRepository.deleteById(id);
	}

	@Override
	public Mono<Reservation> updateReservation(ReservationVO reservationVO, String id) {
				
		return reservationRepository.findById(id).flatMap(currentReservation -> {
			currentReservation.setReservationDate(reservationVO.getReservationDate());
			currentReservation.setBookedBy(reservationVO.getBookedBy());
			currentReservation.setRestaurantId(reservationVO.getRestaurantId());
			currentReservation.setTotalNumberOfPeople(reservationVO.getTotalNumberOfPeople());
			return reservationRepository.save(currentReservation);
		});
	}

}
