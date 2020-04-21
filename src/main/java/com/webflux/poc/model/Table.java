/**
 * 
 */
package com.webflux.poc.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author prabhakar
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/* @Document(collection="restaurantTables") */
public class Table {
	
	@Id
	private String tableId;
	
	private Integer tableCapacity;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date bookingDate;


}
