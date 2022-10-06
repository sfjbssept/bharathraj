package com.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.publisher.entity.User;

@RestController
public class PubliserController {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private String topicName = "spring-kafka";
	
	@GetMapping("/publish/{name}")
	public String publisMessage(@PathVariable String name) {
		kafkaTemplate.send(topicName, "Hi " + name);
		return "message sent";
	}
	
	@GetMapping("/publishjson")
	public String subscribeMessage() {
		User user = new User(101,"bharathraj", new String[] {"chennai", "siruseri", "TCS"});
		kafkaTemplate.send(topicName,user);
		return "message sent";
	}
	
	
}
