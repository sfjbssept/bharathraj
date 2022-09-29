package com.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubliserController {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private String topicName = "spring-kafka";
	
	@PostMapping("/publish/{name}")
	public String publisMessage(@PathVariable String name) {
		kafkaTemplate.send(topicName, "Hi " + name);
		return "message sent";
	}
	
	@GetMapping("/subscribe")
	public String publisMessage(@PathVariable String name) {
		kafkaTemplate.send(topicName, "Hi " + name);
		return "message sent";
	}
}
