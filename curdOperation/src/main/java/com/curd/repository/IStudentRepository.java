package com.curd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.curd.entity.Student;

public interface IStudentRepository extends MongoRepository<Student,Integer> {
	
	

}
