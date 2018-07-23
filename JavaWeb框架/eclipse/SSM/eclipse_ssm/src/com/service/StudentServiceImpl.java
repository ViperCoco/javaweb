package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IStudentDao;
import com.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private IStudentDao sdao;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return sdao.findAll();
	}

	@Override
	public void addStu(Student student) {
		// TODO Auto-generated method stub

		sdao.insertStudent(student);

	}

	@Override
	public Student findById(Integer stuId) {
		// TODO Auto-generated method stub
		return sdao.findById(stuId);
	}

}
