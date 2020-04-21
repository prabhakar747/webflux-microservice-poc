package com.webflux.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webflux.poc.model.User;
import com.webflux.poc.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Flux<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Mono<User> getUserById(String id) {
		 return userRepository.findById(id);
	}

	@Override
	public Mono<User> createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Mono<User> updateUser(User user, String id) {
		 return userRepository.findById(id)
	                .flatMap(currentUser -> {
	                	currentUser.setFirstName(user.getFirstName());
	                	currentUser.setLastName(user.getLastName());
	                	currentUser.setCity(user.getCity());
	                	currentUser.setEmailId(user.getEmailId());
	                	currentUser.setContactNumber(user.getContactNumber());
	                    return userRepository.save(currentUser);
	                });
	}

	@Override
	public Mono<Void> deleteUser(String id) {
		return userRepository.deleteById(id);
	}
	
	
	

}
