package com.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curd.entity.Student;
import com.curd.service.IStudentService;

@RestController
public class StrudentController {

	@Autowired
	IStudentService iStudentService;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		Student savedStudent = iStudentService.saveStudent(student);
		return ResponseEntity.ok(savedStudent);
		
	}
	
	@GetMapping("/getStudent")
	public ResponseEntity<?> getStudents(){
		return ResponseEntity.ok(iStudentService.getStudents());
	}
	
	@PostMapping("/updateStudent/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Integer id){
		Student stu = iStudentService.updateStudent(student, id);
		return ResponseEntity.ok(stu);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Integer id){
		iStudentService.deleteStudent(id);
	}
	
	@DeleteMapping("/deleteAllStudent")
	public void deleteAllStudent(){
		iStudentService.deleteAllStudent();
	}
}
