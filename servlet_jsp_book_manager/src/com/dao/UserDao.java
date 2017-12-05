package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;

//���ݷ��ʲ�
public class UserDao {

	// �����û����������ѯ�û��Ƿ����

	public User findByInfo(User user) {

		User user_find = null;

		// �õ����ݿ�����
		Connection conn = DBConnection.getConnection();

		String sql = "select * from user where username=? and password=?";

		try {
			// Ԥ����sql
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());

			ps.setString(2, user.getPassword());

			// ��ѯ�õ������

			ResultSet rs = ps.executeQuery();

			// �������������ȡ��Ϣ

			while (rs.next()) {

				String username_find = rs.getString("username");

				String password_find = rs.getString("password");

				// ����Ϣ��ֵ������user_find
				user_find = new User(username_find, password_find);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user_find;
	}

	// �����û�����ѯ�û���Ϣ

	public User findByName(String username) {

		User user_find = null;

		// �������ݿ�

		Connection conn = DBConnection.getConnection();

		String sql = "select * from user where username=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			// ��ѯ�õ������

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

	// ���û���Ϣ��ӽ����ݿ�

	public int add(User user) {

		int result = 0;

		// �������ݿ�

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
