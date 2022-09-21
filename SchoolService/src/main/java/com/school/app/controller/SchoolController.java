package com.school.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.app.entity.Student;


@RestController
@RequestMapping("/schoolDetails")
public class SchoolController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/{schoolName}")
	public String getStudents(@PathVariable() String schoolName) throws JsonMappingException, JsonProcessingException {
		
	System.out.println("schoolname: "+ schoolName);
	String url = "http://student-service/getStudentList/" + schoolName;
	HttpHeaders header = new HttpHeaders();
	HttpEntity<String> entity = new HttpEntity<>(header);
	String schoolDetails = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	ObjectMapper objMapper = new ObjectMapper();
	TypeReference<List<Student>> mapType = new TypeReference<List<Student>>() {};
	List<Student> studentList = objMapper.readValue(schoolDetails, mapType);
	
	return "SchoolName - "+ schoolName + " Student one name - "+ studentList.get(0).getName() + " Student two name - "+ studentList.get(1).getName();
	}
}
