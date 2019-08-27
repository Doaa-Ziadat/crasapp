package com.example.appserver.crasapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.appserver.crasapp.domain.Car;
import com.example.appserver.crasapp.domain.Owner;
import com.example.appserver.crasapp.domain.Trip;
import com.example.appserver.crasapp.da.CarRepository;
import com.example.appserver.crasapp.da.OwnerRepository;
import com.example.appserver.crasapp.da.TripRepository;
import com.example.appserver.crasapp.da.DriverRepository;
import com.example.appserver.crasapp.domain.CarOfDriver;
import com.example.appserver.crasapp.domain.Driver;


@SpringBootApplication
public class CrasappApplication {

	  private static final Logger logger = LoggerFactory.getLogger(CrasappApplication.class);


      @Autowired 
      private CarRepository repository;
      
      @Autowired
      private OwnerRepository ownerRepo;
      
      @Autowired
      private TripRepository tripRepo;
      
      @Autowired
      private DriverRepository driverRepo;
      
	public static void main(String[] args) {
		SpringApplication.run(CrasappApplication.class, args);
		logger.info("Hello from crasapp server app");
	}

	
	@Bean
    CommandLineRunner runner(){
      return args -> {
    	  
    	  Owner o1=new Owner("Pini","Cohen");
    	  Owner o2=new Owner("Mariam","Khamaisy");
    			  
      
    		o2.setFirstname("Abdalla");	 
    		//need to persist owner state 
    	    ownerRepo.save(o1);
    		ownerRepo.save(o2);
    		
    		Trip t1=new Trip("tsafona");
    		Trip t2=new Trip("tsafona");
    		Trip t3=new Trip("tsafona");
    		  tripRepo.save(t1);
    		  tripRepo.save(t2);
    		  tripRepo.save(t3);
    		  
    		   Set<Trip> trip_1 = new HashSet<Trip>();
    		trip_1.add(t1);
    		trip_1.add(t2);
    		   Set<Trip> trip_2 = new HashSet<Trip>();
    		   trip_2.add(t3);
    		   trip_2.add(t2);
    		   Set<Trip> trip_3 = new HashSet<Trip>();
    		   trip_1.add(t2);
    		   
	Car c1=new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000,o1,trip_1);
	   Car c2=new Car("Nissan", "Leaf", "White",  "SSJ-3002", 2014, 29000,o2, trip_2); 
	   Car c3=new Car("Toyota","Prius","Silver","KKD-0212",2018,39000,o2, trip_3);
	   repository.save(c1);
	   repository.save(c2);
	   repository.save(c3);

	   Set<CarOfDriver> set_cars_driver= new HashSet<CarOfDriver>();
 	  set_cars_driver.add(new CarOfDriver(c1, true));
 	  set_cars_driver.add(new CarOfDriver(c2, true));

 	  driverRepo.save( new Driver("Sara", set_cars_driver) );	
	  
	};
}
}
