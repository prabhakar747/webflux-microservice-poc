/**
 * 
 */
package com.mindtree.webflux.poc.model;

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
public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String city;
	private String contactNumber;

}
