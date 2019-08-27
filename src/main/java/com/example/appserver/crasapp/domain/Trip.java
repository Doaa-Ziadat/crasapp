package com.example.appserver.crasapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Trip {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)


long trip_id;
String name;



@ManyToMany(mappedBy = "trips")
private Set<Car> cars;



public long getTrip_id() {
	return trip_id;
}
public void setTrip_id(long trip_id) {
	this.trip_id = trip_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



public Trip(String name) {
	super();
	this.name = name;
	}
public Trip() {}




}
