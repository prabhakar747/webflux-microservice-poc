/**
 * 
 */
package com.webflux.poc.service;

import com.webflux.poc.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author prabhakar
 *
 */
public interface UserServiceInterface {

	public Flux<User> getAllUsers();
	public Mono<User> getUserById(String id);
	public Mono<User> createUser(User user);
	public Mono<User> updateUser(User user, String id);
	public Mono<Void> deleteUser(String id);
}
