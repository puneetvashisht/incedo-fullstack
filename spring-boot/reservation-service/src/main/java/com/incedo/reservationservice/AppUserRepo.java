package com.incedo.reservationservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incedo.reservationservice.entities.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Integer>{
	
//	public Reservation findBySourceAndDestination(String source, String destination);

}
