package com.example.appserver.crasapp.da;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appserver.crasapp.domain.Trip;

public interface TripRepository extends JpaRepository<Trip,Long> {

}
