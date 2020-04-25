package com.webflux.poc.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private String employeeId;
	private String name;
	private String dateOfBirth;
	private String gender;
	private String addressLine1;
	private String addressLine2;
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String mobile;
	private String email;
	private List<String> skills;
	private String biography;
	private String website;
}
