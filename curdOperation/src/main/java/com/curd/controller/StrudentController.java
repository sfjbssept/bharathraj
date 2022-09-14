package com.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curd.entity.Student;
import com.curd.repository.IStudentRepository;

@RestController
public class StrudentController {

	@Autowired
	IStudentRepository iStudentRepository;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		Student savedStudent = iStudentRepository.save(student);
		return ResponseEntity.ok(savedStudent);
		
	}
	
	@GetMapping("/getStudent")
	public ResponseEntity<?> getStudents(){
		return ResponseEntity.ok(iStudentRepository.findAll());
	}
}
