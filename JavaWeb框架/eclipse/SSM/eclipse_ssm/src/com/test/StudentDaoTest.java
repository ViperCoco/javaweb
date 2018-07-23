package com.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.IStudentDao;
import com.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:config/spring-mybatis.xml" })

public class StudentDaoTest {

	private static Logger logger = Logger.getLogger(StudentDaoTest.class);

	@Resource
	private IStudentDao udao;

	@Test
	public void findAll() {

		List<Student> list = udao.findAll();

		if (null != list) {

			for (Student student : list) {

				System.out.println(student.toString());
			}

		}

	}

}
