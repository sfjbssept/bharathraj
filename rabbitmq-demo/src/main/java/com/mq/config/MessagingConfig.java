package com.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class MessagingConfig {

	public static final String QUEUENAME = "Employee_queue";
	public static final String ROUTING_KEY = "employee_routingKey";
	public static final String EXCHANGENAME = "Employee-exchange";
	
	@Bean
	public Queue queueName() {
		return new Queue(QUEUENAME);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGENAME);
	}
	
	@Bean
	public Binding bindingQueue(Queue queue,  TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean 
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
	
	
}
