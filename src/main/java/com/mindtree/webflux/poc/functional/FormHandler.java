package com.mindtree.webflux.poc.functional;


import static com.mindtree.webflux.poc.constants.EmployeeConstants.ADDRESS_LINE_1;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.ADDRESS_LINE_2;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.BIOGRAPHY;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.CITY;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.COUNTRY;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.DATE_OF_BIRTH;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.DISPLAY_FORM_DATA;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.EMAIL;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.FORM;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.GENDER;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.MOBILE;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.NAME;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.SKILLS;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.STATE;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.WEBSITE;
import static com.mindtree.webflux.poc.constants.EmployeeConstants.ZIP_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mindtree.webflux.poc.model.Employee;
import com.mindtree.webflux.poc.repository.EmployeeRepository;

import reactor.core.publisher.Mono;

@Component
public class FormHandler {

	public Mono<ServerResponse> sampleForm(ServerRequest request) {

		return ServerResponse.ok().render(FORM);
	}
	
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Mono<ServerResponse> displayFormData(ServerRequest request) {
		
		Mono<MultiValueMap<String, String>> formData = request.formData();
		
		// BodyExtractor based. It didn't result any value for our program
		// It looks any earlier piece of code (Filter ?) already accessed the body
		// making it empty.
		
		// Mono<MultiValueMap<String, String>> formData = request.body(BodyExtractors.toFormData());		
		employeeRepository.save(formDataToEmployee(formData));
		return ServerResponse.ok().render(DISPLAY_FORM_DATA, formDataToEmployee(formData));
	}

	private Employee formDataToEmployee(Mono<MultiValueMap<String, String>> formData) {

		Employee employee = new Employee();

		formData.subscribe(formDatamap -> {
			employee.setName(formDatamap.get(NAME).get(0));
			employee.setDateOfBirth(formDatamap.getFirst(DATE_OF_BIRTH));
			employee.setGender(formDatamap.getFirst(GENDER));
			employee.setAddressLine1(formDatamap.getFirst(ADDRESS_LINE_1));
			employee.setAddressLine2(formDatamap.getFirst(ADDRESS_LINE_2));
			employee.setCountry(formDatamap.getFirst(COUNTRY));
			employee.setState(formDatamap.getFirst(STATE));
			employee.setCity(formDatamap.getFirst(CITY));
			employee.setZipCode(formDatamap.getFirst(ZIP_CODE));
			employee.setMobile(formDatamap.getFirst(MOBILE));
			employee.setEmail(formDatamap.getFirst(EMAIL));
			employee.setSkills(formDatamap.get(SKILLS));
			employee.setWebsite(formDatamap.getFirst(WEBSITE));
			employee.setBiography(formDatamap.getFirst(BIOGRAPHY));
		});

		return employee;
	}
}
