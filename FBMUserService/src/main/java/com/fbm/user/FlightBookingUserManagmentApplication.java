package com.fbm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FlightBookingUserManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingUserManagmentApplication.class, args);
	}

}
