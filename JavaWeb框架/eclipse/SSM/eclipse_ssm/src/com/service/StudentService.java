package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	
	
	public List<Student> findAll();
	
	public void  addStu(Student student);
	
	public Student findById(Integer stuId);
	

}
