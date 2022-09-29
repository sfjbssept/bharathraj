package com.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.publisher.entity.User;

@SpringBootApplication
public class KafkaPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}
	
	User u = new User();

}
