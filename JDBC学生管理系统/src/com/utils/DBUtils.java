package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;

//���ݲ���������
public class DBUtils {

	// ���ѧ����Ϣ(��Ų��ظ�)

	public int add(Student student) {

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			try {

				String sql = "insert into student values(?,?,?,?,?)";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setInt(1, student.getId());

				ps.setString(2, student.getName());

				ps.setString(3, student.getSex());

				ps.setInt(4, student.getAge());

				ps.setString(5, student.getHobby());

				int result = ps.executeUpdate();
				// �ر���Դ
				ps.close();

				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return 0;

	}

	// ����id��ѯѧ����Ϣ

	public Student findById(int stu_id) {

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from student where id=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				// ��������

				ps.setInt(1, stu_id);

				// �õ������

				ResultSet rs = ps.executeQuery();

				// ���������

				Student student = null;
				while (rs.next()) {

					int id = rs.getInt("id");

					String name = rs.getString("name");

					String sex = rs.getString("sex");

					int age = rs.getInt("age");

					String hobby = rs.getString("hobby");

					student = new Student(id, name, sex, age, hobby);

				}

				// �ر���Դ

				ps.close();

				/**********/

				return student;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return null;

	}

	// ��ʾȫ��ѧ����Ϣ

	public List<Student> findAll() {

		List<Student> list = new ArrayList<Student>();

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from student";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				// �õ������

				ResultSet rs = ps.executeQuery();

				// ���������

				while (rs.next()) {

					int id = rs.getInt("id");

					String name = rs.getString("name");

					String sex = rs.getString("sex");

					int age = rs.getInt("age");

					String hobby = rs.getString("hobby");

					Student student = new Student(id, name, sex, age, hobby);

					// ��ÿ�α�������ѧ��������ӽ�����

					list.add(student);

				}

				// �ر���Դ

				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return list;
	}

	// ɾ��ѧ����Ϣ

	public int delById(int id) {

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "delete from student where id=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, id);

				int result = ps.executeUpdate();

				ps.close();

				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return 0;

	}

	// �޸�ѧ����Ϣ(��Ų����޸�)

	public int update(Student student) {

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "update student set name=?,sex=?,age=?,hobby=? where id=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, student.getName());

				ps.setString(2, student.getSex());

				ps.setInt(3, student.getAge());

				ps.setString(4, student.getHobby());

				ps.setInt(5, student.getId());

				int result = ps.executeUpdate();

				ps.close();

				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("���ݿ�����ʧ�ܣ�");

		}

		return 0;
	}

}
