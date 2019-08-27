package com.example.appserver.crasapp.da;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appserver.crasapp.domain.Driver;

public interface DriverRepository extends JpaRepository<Driver,Long> {

}
