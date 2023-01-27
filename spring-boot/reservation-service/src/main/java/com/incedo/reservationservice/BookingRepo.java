package com.incedo.reservationservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incedo.reservationservice.entities.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{
	
//	public Reservation findBySourceAndDestination(String source, String destination);

}
