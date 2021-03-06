/**
 * 
 */
package com.webflux.poc.ws.mappers;

import org.springframework.stereotype.Component;

import com.webflux.poc.model.Reservation;
import com.webflux.poc.valueobjects.ReservationVO;

/**
 * @author prabh
 *
 */
@Component
public class ReservationMapper {
	
	public Reservation convertToDocument(ReservationVO reservationVO) {
		Reservation reservation = new Reservation();
		reservation.setReservationDate(reservationVO.getReservationDate());
		reservation.setRestaurantId(reservationVO.getRestaurantId());
		reservation.setTotalNumberOfPeople(reservationVO.getTotalNumberOfPeople());
		reservation.setBookedBy(reservationVO.getBookedBy());
		return reservation;
	}

}
