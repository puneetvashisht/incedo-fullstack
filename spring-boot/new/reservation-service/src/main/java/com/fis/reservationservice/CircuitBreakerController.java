package com.fis.reservationservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {
	
	@GetMapping("/sample/get")
//	@Retry(name="sample-api", fallbackMethod="responseMethod")
	@CircuitBreaker(name="sample-api", fallbackMethod="responseMethod")
	public String sampleApi() {
		
		System.out.println("Retried........");
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("/sample-api/new", String.class);
		
		return forEntity.getBody();
	}
	
	public String responseMethod (Exception ex) {
		return "ReservationService Fails!!!!!!!!";
	}
}
