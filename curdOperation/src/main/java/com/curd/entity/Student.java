package com.curd.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Student")
public class Student {
	
	private Integer id;
	private String name;
	private String college;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
