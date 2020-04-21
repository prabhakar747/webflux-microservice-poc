/**
 * 
 */
package com.mindtree.webflux.poc.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mindtree.webflux.poc.model.Employee;

/**
 * @author prabhakar
 *
 */
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
	
	

}
