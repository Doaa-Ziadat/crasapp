package com.example.appserver.crasapp.da;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appserver.crasapp.domain.Owner;

public interface OwnerRepository extends JpaRepository <Owner,Long> {

	
}
