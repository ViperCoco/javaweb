package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Book;

//数据访问层
public class BookDao {

	// 查询当前用户可操作的全部图书信息

	public List<Book> findAll(String username) {

		List<Book> list = new ArrayList<Book>();

		// 得到数据库连接
		Connection conn = DBConnection.getConnection();

		String sql = "select * from book where user=? or user=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ps.setString(2, "");
			// 查询得到结果集

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");

				String name = rs.getString("name");

				double price = rs.getDouble("price");

				String info = rs.getString("info");

				String img_url = rs.getString("img_url");

				String borrow_date = rs.getString("borrow_date");

				String user = rs.getString("user");

				Book book = new Book(id, name, price, info, img_url,
						borrow_date, user);

				list.add(book);

			}

			// 测试

			for (Book book : list) {

				System.out.println("db:" + book.toString());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	// 获取最大页数

	public int getMaxPage(String username, int num) {
		int result = 0;// 查询结果

		int PageNum = 0;

		// 得到数据库连接
		Connection conn = DBConnection.getConnection();

		// 聚合查询得到需要显示的数据

		String sql = "select count(*) as count from book where user=? or user=?";

		try {
			// 预编译
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ps.setString(2, "");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt("count");
			}
			// 防止算术异常
			if (num == 0) {

				PageNum = 1;

				return PageNum;

			}
			// 能够整除情况
			if (result % num == 0) {

				PageNum = result / num;

			} else {

				PageNum = result / num + 1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return PageNum;

	}

	// 获取分页数据

	public List<Book> Limit(String username, int page, int num) {

		List<Book> list = new ArrayList<Book>();

		// 得到数据库连接
		Connection conn = DBConnection.getConnection();

		String sql = "select * from book where user=? or user=? limit ?,?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ps.setString(2, "");

			ps.setInt(3, (page - 1) * num);// (查询页数-1)*每页记录数
			ps.setInt(4, num);

			// 查询得到结果集

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");

				String name = rs.getString("name");

				double price = rs.getDouble("price");

				String info = rs.getString("info");

				String img_url = rs.getString("img_url");

				String borrow_date = rs.getString("borrow_date");

				String user = rs.getString("user");

				Book book = new Book(id, name, price, info, img_url,
						borrow_date, user);

				list.add(book);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	// 根据id修改图书信息为借出

	public int updateById(int id, String username) {

		int result = 0;

		// 得到数据库连接
		Connection conn = DBConnection.getConnection();

		String sql = "update book set borrow_date=?,user=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, getDate());

			ps.setString(2, username);

			ps.setInt(3, id);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// 获得当前日期的字符串
	public String getDate() {

		String time = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		time = sdf.format(new Date());

		return time;

	}

	// 计算借出天数

	public int getDays(String borrow_time, String back_time) {

		int days = 0;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date date_borrow = format.parse(borrow_time);

			Date date_back = format.parse(back_time);

			// 转换为毫秒

			long borrow = date_borrow.getTime();

			long back = date_back.getTime();

			// 计算租金

			days = (int) ((back - borrow) / 1000 / 60 / 60 / 24);

			System.out.println("共借出了:" + days + "天");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return days;

	}

	// 根据id查找图书信息

	public Book findById(int id) {

		Book book = null;

		// 得到数据库连接
		Connection conn = DBConnection.getConnection();
		String sql = "select * from book where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			// 查询得到结果集

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id_find = rs.getInt("id");

				String name = rs.getString("name");

				double price = rs.getDouble("price");

				String info = rs.getString("info");

				String img_url = rs.getString("img_url");

				String borrow_date = rs.getString("borrow_date");

				String user = rs.getString("user");

				book = new Book(id_find, name, price, info, img_url,
						borrow_date, user);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;

	}

	// 根据id修改图书信息为归还

	public int updateById(int id) {

		int result = 0;

		// 得到数据库连接
		Connection conn = DBConnection.getConnection();

		String sql = "update book set borrow_date=?,user=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "尚未借出");

			ps.setString(2, "");

			ps.setInt(3, id);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
