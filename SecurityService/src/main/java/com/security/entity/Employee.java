package com.security.entity;

import java.util.Objects;

public class Employee {
	
	private String name;
	
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee emp = (Employee) obj;
		return Objects.equals(this.name, emp.name) && Objects.equals(this.role, emp.role);
	}
	
	
	
	

}
