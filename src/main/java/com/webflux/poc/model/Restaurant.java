/**
 * 
 */
package com.webflux.poc.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@ToString
public class Restaurant {
	
	@Id
	private String restaurantId;
	private String restaurantName;
	private String city;
	
	//Embedded document technique is better option for search criteria.
	private List<Table> tables;
	
	
	
}
