package com.fis.reservationservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	public Reservation findBySourceAndDestination (String source, String destination);
}
