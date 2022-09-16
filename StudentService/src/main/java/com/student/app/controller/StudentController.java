package com.student.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.entity.Student;

@RestController
public class StudentController {
	
	private static Map<String, List<Student>> schoolDb = new HashMap<String,List<Student>>();
	
	static {
		List<Student> school1StudentList = new ArrayList<>();
		List<Student> school2StudentList = new ArrayList<>();
		
		Student st1 = new Student("ram","class10");
		school1StudentList.add(st1);
		st1 = new Student("raj", "class11");
		school1StudentList.add(st1);
		schoolDb.put("school1", school1StudentList);
		
		st1 = new Student("ravi","class12");
		school2StudentList.add(st1);
		st1 = new Student("bharath","class10");
		school2StudentList.add(st1);
		schoolDb.put("school2", school2StudentList);
	}
	
	
	@GetMapping("/getStudentList/{schoolName}")
	public List<Student> getStudents(@PathVariable String schoolName){
		List<Student> stuLst = schoolDb.get(schoolName);
		if(stuLst == null) {
			stuLst = new ArrayList<>();
			Student std = new Student("Not Found", "N/A");
			stuLst.add(std);
		}
		return stuLst;
	}
//	public static void main(String[] args) {
//		System.out.println(school1.get("school1").get(0).getName());
//		System.out.println(school1.get("school1").get(1).getName());
//	}

}
