package microservices.reservationbookingservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="reservation-service", url="${reservation-service.ribbon.listOfServers}")
@FeignClient(name="reservation-service")
//@FeignClient(name = "reservation-service", url = "${RESERVATION_SERVICE_HOST:http://localhost}:8000")
public interface ReservationBookingServiceProxy {
	
//	@GetMapping(path ="/reservation/from/{source}/to/{destination}")
	@GetMapping(path ="/reservation/from/{source}/to/{destination}")
	public ReservationBookingBean fetchPrice(@PathVariable("source") String source, @PathVariable("destination") String destination) ;
}
