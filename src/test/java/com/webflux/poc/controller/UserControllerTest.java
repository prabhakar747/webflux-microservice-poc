package com.webflux.poc.controller;
/**
 * 
 */
/*
 * package com.webflux.poc.controller;
 * 
 * import static org.junit.Assert.assertTrue;
 * 
 * import java.util.Arrays; import java.util.List;
 * 
 * import org.junit.Before; import org.junit.runner.RunWith; import
 * org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.reactive.
 * AutoConfigureWebTestClient; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.annotation.DirtiesContext; import
 * org.springframework.test.context.ActiveProfiles; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.test.web.reactive.server.WebTestClient;
 * 
 * import com.webflux.poc.constants.RestaurantBookingConstants; import
 * com.webflux.poc.model.User; import
 * com.webflux.poc.repository.UserRepository;
 * 
 * import reactor.core.publisher.Flux;
 * 
 *//**
	 * @author prabhakar
	 *
	 *//*
		 * @SpringBootTest
		 * 
		 * @RunWith(SpringRunner.class)
		 * 
		 * @DirtiesContext
		 * 
		 * @AutoConfigureWebTestClient
		 * 
		 * @ActiveProfiles("dev") public class UserControllerTest {
		 * 
		 * @Autowired WebTestClient webTestClient;
		 * 
		 * @Autowired UserRepository userRepository;
		 * 
		 * public List<User> data(){ return Arrays.asList(new
		 * User(null,"Prabhakar","Naidu","prabha@mindrree.com","Gaithresburg",
		 * "1234455555"), new
		 * User(null,"Jesse","Pinkmen","Jesse@mindrree.com","Gaithresburg","1234455555")
		 * , new
		 * User("BreBad","Hank","Schr","hank@mindrree.com","Gaithresburg","1234455555"))
		 * ; }
		 * 
		 * @Before public void setUp(){ userRepository.deleteAll()
		 * .thenMany(Flux.fromIterable(data())) .flatMap(userRepository::save)
		 * .doOnNext((item -> { System.out.println("Inserted User is : " + item); }))
		 * .blockLast(); }
		 * 
		 * @Test public void getAllUsers() { System.out.println("TestCase run");
		 * webTestClient.get().uri(RestaurantBookingConstants.USERS_END_POINT_V1)
		 * .exchange() .expectStatus().isOk()
		 * .expectHeader().contentType(MediaType.APPLICATION_JSON)
		 * .expectBodyList(User.class) .hasSize(3); }
		 * 
		 * 
		 * @Test public void getAllUsers_two() { System.out.println("TestCase run");
		 * webTestClient.get().uri(RestaurantBookingConstants.USERS_END_POINT_V1)
		 * .exchange() .expectStatus().isOk()
		 * .expectHeader().contentType(MediaType.APPLICATION_JSON)
		 * .expectBodyList(User.class) .hasSize(3) .consumeWith((response) -> {
		 * List<User> items = response.getResponseBody(); items.forEach((item) -> {
		 * assertTrue(item.getId()!=null); }); }); } }
		 */