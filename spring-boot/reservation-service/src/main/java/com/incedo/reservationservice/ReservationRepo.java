package com.incedo.reservationservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incedo.reservationservice.entities.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Integer>{
	
	public Reservation findBySourceAndDestination(String source, String destination);

}
