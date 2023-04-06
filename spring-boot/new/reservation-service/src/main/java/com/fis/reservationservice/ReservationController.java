package com.fis.reservationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;




@RestController
public class ReservationController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	Environment environment;
	
	 @Bean
	    public Sampler alwaysSampler() {
	        return Sampler.ALWAYS_SAMPLE;
	    }
	
	private Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(path = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<Void>addReservation(@RequestBody Reservation reservation){
		reservationRepository.save(reservation);
		ResponseEntity<Void> re =new ResponseEntity<>(HttpStatus.CREATED);
		return re;
	}
	
	@RequestMapping(path = "/reservation/from/{source}/to/{destination}", method = RequestMethod.GET)
//	@Retry(name="default",fallbackMethod="responseMethod")
	public Reservation fetchPrice(@PathVariable("source") String source, @PathVariable("destination") String destination){
		
		logger.info("Request Executed.............");
//		System.out.println("Request Executed.............");
		Reservation reservation = reservationRepository.findBySourceAndDestination(source, destination);
		
		String port = environment.getProperty("local.server.port");
		
		String host = environment.getProperty("HOSTNAME");
		logger.info("HostName is "+ host);
		String version = "v1";
		
		reservation.setEnvironment(port + " " + version + " " + host);
		
		return reservation;
		
	}
	
//	public String responseMethod (Exception ex) {
//		return "ReservationService Fails!!!!!!!!";
//	}

}
