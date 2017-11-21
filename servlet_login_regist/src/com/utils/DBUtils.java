package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;

public class DBUtils {

	// 根据用户名和密码查询

	public User findUser(User user) {

		User user_find = null;

		// 连接数据库
		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from user where username=? and password=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, user.getUsername());

				ps.setString(2, user.getPassword());

				ResultSet rs = ps.executeQuery();

				// 遍历结果集

				while (rs.next()) {

					String username = rs.getString("username");

					String password = rs.getString("password");

					user_find = new User(username, password);

				}

				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("数据库连接失败！");

		}

		return user_find;

	}

	// 根据用户名查询
	public User findUserByName(String username) {

		User user_find = null;

		// 连接数据库
		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from user where username=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, username);

				ResultSet rs = ps.executeQuery();

				// 遍历结果集

				while (rs.next()) {

					String username_find = rs.getString("username");

					String password = rs.getString("password");

					user_find = new User(username_find, password);

				}

				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("数据库连接失败！");

		}

		return user_find;

	}

	// 将用户信息添加进数据库

	public int addUser(User user) {

		int result = 0;

		// 连接数据库
		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "insert into user(username,password) values(?,?)";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, user.getUsername());

				ps.setString(2, user.getPassword());

				result = ps.executeUpdate();
				
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("数据库连接失败！");

		}

		return result;
	}

}
