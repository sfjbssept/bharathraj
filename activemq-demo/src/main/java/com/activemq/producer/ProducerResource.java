package com.activemq.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {
	
	@Autowired
	private JmsTemplate template;
	
	@Autowired
	private Queue queue;
	
	@GetMapping("/{msg}")
	public String publishMsg(@PathVariable String msg) {
		template.convertAndSend(queue, msg);
		return "Success";
	}
	
	

}
