package com.security.controller;



import java.time.ZonedDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Employee;

@RestController
public class AppController {
	
	@GetMapping(value="/get")
	public String getDetails(){
		return "employee";
	}
	
	@PostMapping("/post")
	Employee postEmployee(@RequestBody Employee emp) {
		return emp;
	}
	
	@PutMapping("/put/{name}")
	String putEmployee(@RequestBody Employee emp, @PathVariable String name) {
		return emp.toString() + "update with name "+ name;
	}
	
	@DeleteMapping("/delete/{name}")
	String deleteEmployee(@PathVariable String name) {
		return name;
	}
	
	@GetMapping("/path/{name}")
	String getPathVariable(@PathVariable String name) {
		return "Path variable "+ name;
	}
	
	@GetMapping("/request")
	String getReqParam(@RequestParam(name="name",required = true,defaultValue = "test")String name) {
		return "Request Param : "+ name;
	}
	
	@GetMapping("/headers")
	public ResponseEntity<String> getRequestparam(@RequestHeader HttpHeaders header){
		if(isHeaderMissing(header,"name")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setExpires(ZonedDateTime.now().plusDays(1));
		String resp = "valid header";
		return ResponseEntity.ok().headers(responseHeader).body(resp);
	}
	
	private boolean isHeaderMissing(final HttpHeaders header, final String headerkey) {
		if(!header.containsKey(headerkey)) {
			return true;
		} else {
			return false;
		}
	}
	
}
