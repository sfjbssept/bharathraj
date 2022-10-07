package com.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerResource {

	@JmsListener(destination="standalone.queue")
	public void consume(String msg) {
		System.out.println("Received Message is " + msg);
	}
}
