package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;

public class DBUtils {

	// �����û����������ѯ

	public User findUser(User user) {

		User user_find = null;

		// �������ݿ�
		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from user where username=? and password=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, user.getUsername());

				ps.setString(2, user.getPassword());

				ResultSet rs = ps.executeQuery();

				// ���������

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

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return user_find;

	}

	// �����û�����ѯ
	public User findUserByName(String username) {

		User user_find = null;

		// �������ݿ�
		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from user where username=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, username);

				ResultSet rs = ps.executeQuery();

				// ���������

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

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return user_find;

	}

	// ���û���Ϣ��ӽ����ݿ�

	public int addUser(User user) {

		int result = 0;

		// �������ݿ�
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

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return result;
	}

}
