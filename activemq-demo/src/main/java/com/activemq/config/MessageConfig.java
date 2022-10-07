package com.activemq.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessageConfig {
	
	@Value("${activemq.broker-url}")
	private String brokerUrl;
	
	@Value("${username}")
	private String userName;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("standalone.queue");
	}

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerUrl);
//		factory.setUserName(userName);
//		factory.setPassword(password);
		return factory;
		
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
