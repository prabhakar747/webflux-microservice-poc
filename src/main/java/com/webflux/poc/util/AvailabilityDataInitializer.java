package com.webflux.poc.util;
/*
 * package com.booking.restaurant.util;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.context.annotation.Profile; import
 * org.springframework.data.mongodb.core.MongoOperations; import
 * org.springframework.stereotype.Component;
 * 
 * import com.booking.restaurant.model.User; import
 * com.booking.restaurant.repository.UserRepository;
 * 
 * import lombok.extern.slf4j.Slf4j; import reactor.core.publisher.Flux;
 * 
 * @Component
 * 
 * @Profile("!test")
 * 
 * @Slf4j public class AvailabilityDataInitializer implements CommandLineRunner
 * {
 * 
 * @Autowired UserRepository userRepository;
 * 
 * @Autowired MongoOperations mongoOperations;
 * 
 * Logger logger = LoggerFactory.getLogger(AvailabilityDataInitializer.class);
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * initalDataSetUp(); }
 * 
 * private void initalDataSetUp() {
 * 
 * if(logger.isDebugEnabled()) { logger.debug("User : initalDataSetUp()"); }
 * 
 * userRepository.deleteAll() .thenMany(Flux.fromIterable(initializeUsers()))
 * .flatMap(userRepository::save) .thenMany(userRepository.findAll())
 * .subscribe((user -> {
 * System.out.println("User inserted from CommandLineRunner : "+user.toString())
 * ; }));
 * 
 * }
 * 
 * public List<User> initializeUsers() { List<User> userList = new
 * ArrayList<User>();
 * 
 * for(int i=1;i<=3;i++) { User user = new User(); user.setCity("City "+i);
 * user.setContactNumber("123456789"); user.setEmailId(i+"_user@gmail.com");
 * user.setFirstName("FN_"+i); user.setLastName("LN_"+i); userList.add(user); }
 * return userList; }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */