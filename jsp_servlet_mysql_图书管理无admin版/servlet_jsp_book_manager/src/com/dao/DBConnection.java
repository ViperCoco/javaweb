package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection conn;

	public static String url = "jdbc:mysql://localhost:3306/17101db?useUnicode=true&characterEncoding=UTF-8";

	public static String username = "root";

	public static String password = "root";

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {

		return conn;

	}

}
