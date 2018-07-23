package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Student;

public interface IStudentDao {

	public int insertStudent(Student student);

	public List<Student> findAll();// ��ѯȫ��

	public Student findById(@Param("stuId") Integer stuId);// ����stuId����

}
