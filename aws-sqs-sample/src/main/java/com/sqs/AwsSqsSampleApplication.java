package com.sqs;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
@RestController
public class AwsSqsSampleApplication {
	
	Logger logger = LoggerFactory.getLogger(AwsSqsSampleApplication.class);

	@Autowired
	private QueueMessagingTemplate template;
	
	@Value("${cloud.aws.end-point.url}")
	private String endpoint;
	
	@GetMapping("/post/{msg}")
	public void postMsg(@PathVariable("msg") String msg){
		template.send(endpoint,MessageBuilder.withPayload(msg).build());
	}
	
	@SqsListener("first-queue")
	public void listen(String msg) {
		logger.info("Message for queue: {} ", msg);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AwsSqsSampleApplication.class, args);
	}

}
