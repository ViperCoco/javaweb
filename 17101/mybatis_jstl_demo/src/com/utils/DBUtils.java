package com.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
	
	
	public static SqlSession openSqlSession() {

		SqlSession session = null;

		try {
			InputStream is = Resources
					.getResourceAsStream("com/config/mybatis.xml");
			// �����Ự����
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			// �����Ự
			session = sf.openSession();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return session;
	}
	

}
