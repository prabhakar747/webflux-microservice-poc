/**
 * 
 */
package com.webflux.poc.valueobjects;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author prabhakar
 *
 */
public class ReservationVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private String restaurantId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date reservationDate;
	private String bookedBy;
	private Integer totalNumberOfPeople;
	
	
	
	/**
	 * 
	 */
	private ReservationVO() {
		super();
	}
	/**
	 * @param reservationId
	 * @param restaurantId
	 * @param reservationDate
	 * @param bookedBy
	 * @param totalNumberOfPeople
	 */
	private ReservationVO(String restaurantId, Date reservationDate, String bookedBy,
			Integer totalNumberOfPeople) {
		super();
		this.restaurantId = restaurantId;
		this.reservationDate = reservationDate;
		this.bookedBy = bookedBy;
		this.totalNumberOfPeople = totalNumberOfPeople;
	}
	/**
	 * @return the totalNumberOfPeople
	 */
	public Integer getTotalNumberOfPeople() {
		return totalNumberOfPeople;
	}
	/**
	 * @param totalNumberOfPeople the totalNumberOfPeople to set
	 */
	public void setTotalNumberOfPeople(Integer totalNumberOfPeople) {
		this.totalNumberOfPeople = totalNumberOfPeople;
	}
	/**
	 * @return the restaurantId
	 */
	public String getRestaurantId() {
		return restaurantId;
	}
	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	/**
	 * @return the reservationDate
	 */
	public Date getReservationDate() {
		return reservationDate;
	}
	/**
	 * @param reservationDate the reservationDate to set
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	/**
	 * @return the bookedBy
	 */
	public String getBookedBy() {
		return bookedBy;
	}
	/**
	 * @param bookedBy the bookedBy to set
	 */
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	
	
	
	
	
	
	

}
