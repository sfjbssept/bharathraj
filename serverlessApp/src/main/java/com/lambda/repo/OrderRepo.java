package com.lambda.repo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.lambda.entity.Order;

@Repository
public class OrderRepo {

	public List<Order> buildOrders(){
		return Arrays.asList(new Order(1,"iphone",100000,1),
				new Order(2,"samsung",100000,5),
				new Order(3,"redmi",100000,9),
				new Order(4,"motorola",100000,4),
				new Order(5,"sony",100000,8));
	}

}
