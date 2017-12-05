package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;

//数据访问层
public class UserDao {

	// 根据用户名和密码查询用户是否存在

	public User findByInfo(User user) {

		User user_find = null;

		// 得到数据库连接
		Connection conn = DBConnection.getConnection();

		String sql = "select * from user where username=? and password=?";

		try {
			// 预编译sql
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());

			ps.setString(2, user.getPassword());

			// 查询得到结果集

			ResultSet rs = ps.executeQuery();

			// 遍历结果集，获取信息

			while (rs.next()) {

				String username_find = rs.getString("username");

				String password_find = rs.getString("password");

				// 将信息赋值给对象user_find
				user_find = new User(username_find, password_find);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user_find;
	}

	// 根据用户名查询用户信息

	public User findByName(String username) {

		User user_find = null;

		// 连接数据库

		Connection conn = DBConnection.getConnection();

		String sql = "select * from user where username=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			// 查询得到结果集

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String username_find = rs.getString("username");

				String password_find = rs.getString("password");

				user_find = new User(username_find, password_find);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user_find;

	}

	// 将用户信息添加进数据库

	public int add(User user) {

		int result = 0;

		// 连接数据库

		Connection conn = DBConnection.getConnection();

		String sql = "insert into user(username,password)values(?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());

			ps.setString(2, user.getPassword());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
