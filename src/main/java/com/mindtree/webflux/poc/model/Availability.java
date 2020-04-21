/**
 * 
 */
package com.mindtree.webflux.poc.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author prabhakar
 *
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Availability {
	
	@Id
	private String id;
	private String restaurantId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date forDate;
	private String city;
	private Integer totalCapacity;
	private Integer available;
		

}
