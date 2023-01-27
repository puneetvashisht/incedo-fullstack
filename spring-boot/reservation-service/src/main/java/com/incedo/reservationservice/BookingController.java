package com.incedo.reservationservice;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.reservationservice.entities.AppUser;
import com.incedo.reservationservice.entities.Booking;
import com.incedo.reservationservice.entities.Reservation;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	ReservationRepo reservationRepo;
	
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	AppUserRepo appUserRepo;
	
	@PostMapping("/")
	public ResponseEntity<Void> addBooking(@RequestBody Booking booking) {
		
		System.out.println("In addBooking" + booking);
		Reservation reservation = reservationRepo.findBySourceAndDestination(booking.getSource(), booking.getDestination());
		
		if(booking.getAppUser().getId() > 0) {
			Optional<AppUser> appUser = appUserRepo.findById(booking.getAppUser().getId());
			if(appUser.isPresent()) {
				booking.setAppUser(appUser.get());
			}
		}
		
		booking.setTotalPrice(booking.getQuantity() * reservation.getPrice());
		booking.setCreatedAt(LocalDateTime.now());
//		reservationRepo.save(booking);
		bookingRepo.save(booking);
		
		ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.CREATED);
		return re;

	}
	
//	@GetMapping("/")
//	public List<Reservation> fetchAllReservations(){
//		return reservationRepo.findAll();
//	}
//	
//	@GetMapping("/from/{source}/to/{destination}")
//	public Reservation fetchReservationWithSourceAndDestination(@PathVariable("source") String source, @PathVariable("destination") String destination){
//		return reservationRepo.findBySourceAndDestination(source, destination);
//	}

}
