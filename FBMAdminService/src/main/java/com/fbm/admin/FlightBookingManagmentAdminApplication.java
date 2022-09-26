package com.fbm.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FlightBookingManagmentAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingManagmentAdminApplication.class, args);
	}

}
