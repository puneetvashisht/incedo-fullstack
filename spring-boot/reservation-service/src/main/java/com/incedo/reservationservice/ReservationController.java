package com.incedo.reservationservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.reservationservice.entities.Reservation;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationRepo reservationRepo;
	
	@PostMapping("/")
	public ResponseEntity<Void> addReservation(@RequestBody Reservation reservation) {
		reservationRepo.save(reservation);
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;

	}
	
	@GetMapping("/")
	public List<Reservation> fetchAllReservations(){
		return reservationRepo.findAll();
	}
	
	@GetMapping("/from/{source}/to/{destination}")
	public Reservation fetchReservationWithSourceAndDestination(@PathVariable("source") String source, @PathVariable("destination") String destination){
		return reservationRepo.findBySourceAndDestination(source, destination);
	}

}
