package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn;

	// ?useUnicode=true&characterEncoding=UTF-8 ��ֹ���ĳ�������
	private static String url = "jdbc:mysql://localhost:3306/17101db?useUnicode=true&characterEncoding=UTF-8";

	private static String username = "root";

	private static String password = "root";
	// static����飬ֻ������ص�ʱ��ִ��һ��
	static {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {

		return conn;
	}

}
