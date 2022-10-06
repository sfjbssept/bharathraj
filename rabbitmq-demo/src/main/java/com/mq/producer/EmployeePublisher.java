package com.mq.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mq.config.MessagingConfig;
import com.mq.entity.Employee;
import com.mq.entity.EmployeeStatus;

@RestController
public class EmployeePublisher {
	
	@Autowired
	private RabbitTemplate restTemplate;
	
	@PostMapping("/emp")
	public String saveemployee(@RequestBody Employee employee) {
		employee.setId(UUID.randomUUID().toString());
		
		EmployeeStatus employeeStatus = new EmployeeStatus(employee, "Joined", "Welcome"+employee.getName());
		restTemplate.convertAndSend(MessagingConfig.EXCHANGENAME, MessagingConfig.ROUTING_KEY,employeeStatus);
		return "Success";
	}

}
