/**
 * 
 */
package com.mindtree.webflux.poc.valueobjects;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author prabhakar
 *
 */

public class AvailabilityVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String city;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date forDate;
	private Integer numberOfGuests;
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the forDate
	 */
	public Date getForDate() {
		return forDate;
	}
	/**
	 * @param forDate the forDate to set
	 */
	public void setForDate(Date forDate) {
		this.forDate = forDate;
	}
	/**
	 * @return the numberOfGuests
	 */
	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}
	/**
	 * @param numberOfGuests the numberOfGuests to set
	 */
	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
	

}
