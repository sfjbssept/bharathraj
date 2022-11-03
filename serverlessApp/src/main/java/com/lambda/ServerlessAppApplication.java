package com.lambda;



import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lambda.entity.Order;
import com.lambda.repo.OrderRepo;

@SpringBootApplication
public class ServerlessAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerlessAppApplication.class, args);
	}
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Bean
	public Supplier<List<Order>> orders(){
		
		return ()-> orderRepo.buildOrders();
	}
	
	@Bean
	public Function<String, List<Order>> orderByname(){
		return (input)-> orderRepo.buildOrders().stream().filter(order -> order.getName().equals(input)).collect(Collectors.toList());
	}

}
