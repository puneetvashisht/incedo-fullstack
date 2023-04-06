package microservices.reservationbookingservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;


@RestController
public class ReservationBookingController {
	
	private Logger logger = LoggerFactory.getLogger(ReservationBookingController.class);
	
	@Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	
	@Autowired
	ReservationBookingServiceProxy reservationBookingServiceProxy;
	
	@GetMapping("price-calculator/from/{source}/to/{destination}/quantity/{quantity}")
	public ReservationBookingBean calculatePrice (@PathVariable("source") String source, 
			@PathVariable("destination") String destination,
			@PathVariable("quantity") int quantity) {
		
		logger.info("calculatePrice called with {} to {} with {}", source, destination, quantity);

		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("source", source);
		uriVariables.put("destination", destination);
		
		ResponseEntity<ReservationBookingBean> responseEntity =  new RestTemplate().getForEntity(
				"http://localhost:8000/reservation/from/{source}/to/{destination}", 
				ReservationBookingBean.class,
				uriVariables);
		
		ReservationBookingBean response = responseEntity.getBody();
		
		response.setTotalPrice((quantity)*(response.getPrice()));
		
		return response;
	}
	
	@GetMapping("price-calculator-feign/from/{source}/to/{destination}/quantity/{quantity}")
	public ReservationBookingBean calculatePriceFeign (@PathVariable("source") String source, 
			@PathVariable("destination") String destination,
			@PathVariable("quantity") int quantity){
		
		logger.info("calculatePriceFeign called with {} to {} with {}", source, destination, quantity);

		ReservationBookingBean response = reservationBookingServiceProxy.fetchPrice(source, destination);
		response.setTotalPrice((quantity)*(response.getPrice()));
		
		System.out.println("------------------- " + response);
		return response;
		
		// Invocation Code
	}
}
