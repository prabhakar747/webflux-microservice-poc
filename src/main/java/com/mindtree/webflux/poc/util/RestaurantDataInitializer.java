package com.mindtree.webflux.poc.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.mindtree.webflux.poc.model.Restaurant;
import com.mindtree.webflux.poc.model.Table;
import com.mindtree.webflux.poc.repository.RestaurantRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("!test")
@Slf4j
public class RestaurantDataInitializer implements CommandLineRunner {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MongoOperations mongoOperations;
    
    Logger logger = LoggerFactory.getLogger(RestaurantDataInitializer.class);

    @Override
    public void run(String... args) throws Exception {

        initalDataSetUp();
    }

    private void initalDataSetUp() {
    	
    	if(logger.isDebugEnabled()) {
    		  logger.debug("Restaurant : initalDataSetUp()");
  		}

    	restaurantRepository.deleteAll();
		/*
		 * .thenMany(Flux.fromIterable(initializeRestaurants()))
		 * .flatMap(restaurantRepository::save)
		 * .thenMany(restaurantRepository.findAll()) .subscribe((res -> {
		 * System.out.println("Restaurant inserted from CommandLineRunner : "+res.
		 * toString()); }));
		 */

    }
    
    
    public List<Restaurant> initializeRestaurants() {
    	List<Restaurant> restaurantList = new ArrayList<Restaurant>();
    
    	for(int i=1;i<=2;i++) {
    		Restaurant restaurant = new Restaurant();
    		restaurant.setCity("City_"+1);
    		restaurant.setRestaurantName("R_NAME_"+i);
    		restaurant.setTables(initializeTables());
    		restaurantList.add(restaurant);
    	}
        return restaurantList;
    }
    
    public List<Table> initializeTables(){
    	List<Table> tablesList = new ArrayList<Table>();
    	 
    	for(int i=1;i<=5;i++) {
    		Table table = new Table();
    		table.setBookingDate(new Date());
    		table.setTableCapacity(5);
    		tablesList.add(table);
    	}
    	
		return tablesList;
    }

   

    



}
