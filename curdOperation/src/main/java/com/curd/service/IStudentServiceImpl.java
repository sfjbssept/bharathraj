package com.curd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.entity.Student;
import com.curd.repository.IStudentRepository;

@Service
public class IStudentServiceImpl implements IStudentService {
	
	@Autowired
	IStudentRepository iStudentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return iStudentRepository.save(student);	
	}
	
	@Override
	public List<Student> getStudents() {
		return iStudentRepository.findAll();	
	}
	
	@Override
	public Student updateStudent(Student student, Integer id) {
		Optional<Student> existingStudentOpt = iStudentRepository.findById(id);
		Student existingStudent;
		if(existingStudentOpt.isPresent()) {
			existingStudent = existingStudentOpt.get();
			existingStudent.setCity(student.getCity());
			existingStudent.setName(student.getName());
			existingStudent.setCollege(student.getCollege());
			return saveStudent(existingStudent);
		}
		return student;
	}
	
	@Override
	public void deleteStudent(Integer id) {
		iStudentRepository.deleteById(id);
	}

	@Override
	public void deleteAllStudent() {
		iStudentRepository.deleteAll();
	}

}
