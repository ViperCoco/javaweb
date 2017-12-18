package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bean.Student;
import com.dao.StudentDao;
import com.utils.DBUtils;

public class TestDemo {

	
	@Test
	public void findAll() {

		SqlSession session = DBUtils.openSqlSession();

		StudentDao sdao = session.getMapper(StudentDao.class);

		List<Student> list = sdao.findall();

		for (Student student : list) {

			System.out.println(student.toString());
		}

	}

}
