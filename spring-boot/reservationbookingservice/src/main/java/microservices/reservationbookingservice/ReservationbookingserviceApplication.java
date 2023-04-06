package microservices.reservationbookingservice;




import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("microservices.reservationbookingservice")
//@EnableDiscoveryClient
public class ReservationbookingserviceApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ReservationbookingserviceApplication.class, args);
	}

}
