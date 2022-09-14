package com.curd.service;

import java.util.List;

import com.curd.entity.Student;

public interface IStudentService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getStudents();
	
	public Student updateStudent(Student student, Integer id);
	
	public void deleteStudent(Integer id);

	public void deleteAllStudent();

}
