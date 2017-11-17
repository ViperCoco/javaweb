package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;

//数据操作工具类
public class DBUtils {

	// 添加学生信息(编号不重复)

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
				// 关闭资源
				ps.close();

				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("数据库连接失败！");

		}

		return 0;

	}

	// 根据id查询学生信息

	public Student findById(int stu_id) {

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from student where id=?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				// 填入数据

				ps.setInt(1, stu_id);

				// 得到结果集

				ResultSet rs = ps.executeQuery();

				// 迭代结果集

				Student student = null;
				while (rs.next()) {

					int id = rs.getInt("id");

					String name = rs.getString("name");

					String sex = rs.getString("sex");

					int age = rs.getInt("age");

					String hobby = rs.getString("hobby");

					student = new Student(id, name, sex, age, hobby);

				}

				// 关闭资源

				ps.close();

				/**********/

				return student;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("数据库连接失败！");

		}

		return null;

	}

	// 显示全部学生信息

	public List<Student> findAll() {

		List<Student> list = new ArrayList<Student>();

		Connection conn = DBConnection.getConnection();

		if (conn != null) {

			String sql = "select * from student";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				// 得到结果集

				ResultSet rs = ps.executeQuery();

				// 迭代结果集

				while (rs.next()) {

					int id = rs.getInt("id");

					String name = rs.getString("name");

					String sex = rs.getString("sex");

					int age = rs.getInt("age");

					String hobby = rs.getString("hobby");

					Student student = new Student(id, name, sex, age, hobby);

					// 将每次遍历出的学生对象添加进集合

					list.add(student);

				}

				// 关闭资源

				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			System.out.println("数据库连接失败！");

		}

		return list;
	}

	// 删除学生信息

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

			System.out.println("数据库连接失败！");

		}

		return 0;

	}

	// 修改学生信息(编号不能修改)

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

			System.out.println("数据库连接失败！");

		}

		return 0;
	}

}
