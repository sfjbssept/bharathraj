package com.gateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

	@Autowired
	public RestTemplate restTemplate;
	
	@GetMapping(value="/getSchool/{schoolName}")
	public String getSchoolDetails(@PathVariable String schoolName) {
		String url = "http://school-service/schoolDetails/" + schoolName;
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(header);
		String schoolDetails = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		return schoolDetails;
	}
}
