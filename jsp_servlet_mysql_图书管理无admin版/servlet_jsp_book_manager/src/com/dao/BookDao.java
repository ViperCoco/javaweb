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

//���ݷ��ʲ�
public class BookDao {

	// ��ѯ��ǰ�û��ɲ�����ȫ��ͼ����Ϣ

	public List<Book> findAll(String username) {

		List<Book> list = new ArrayList<Book>();

		// �õ����ݿ�����
		Connection conn = DBConnection.getConnection();

		String sql = "select * from book where user=? or user=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ps.setString(2, "");
			// ��ѯ�õ������

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

			// ����

			for (Book book : list) {

				System.out.println("db:" + book.toString());

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	// ��ȡ���ҳ��

	public int getMaxPage(String username, int num) {
		int result = 0;// ��ѯ���

		int PageNum = 0;

		// �õ����ݿ�����
		Connection conn = DBConnection.getConnection();

		// �ۺϲ�ѯ�õ���Ҫ��ʾ������

		String sql = "select count(*) as count from book where user=? or user=?";

		try {
			// Ԥ����
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ps.setString(2, "");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getInt("count");
			}
			// ��ֹ�����쳣
			if (num == 0) {

				PageNum = 1;

				return PageNum;

			}
			// �ܹ��������
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

	// ��ȡ��ҳ����

	public List<Book> Limit(String username, int page, int num) {

		List<Book> list = new ArrayList<Book>();

		// �õ����ݿ�����
		Connection conn = DBConnection.getConnection();

		String sql = "select * from book where user=? or user=? limit ?,?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			ps.setString(2, "");

			ps.setInt(3, (page - 1) * num);// (��ѯҳ��-1)*ÿҳ��¼��
			ps.setInt(4, num);

			// ��ѯ�õ������

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

	// ����id�޸�ͼ����ϢΪ���

	public int updateById(int id, String username) {

		int result = 0;

		// �õ����ݿ�����
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

	// ��õ�ǰ���ڵ��ַ���
	public String getDate() {

		String time = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		time = sdf.format(new Date());

		return time;

	}

	// ����������

	public int getDays(String borrow_time, String back_time) {

		int days = 0;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date date_borrow = format.parse(borrow_time);

			Date date_back = format.parse(back_time);

			// ת��Ϊ����

			long borrow = date_borrow.getTime();

			long back = date_back.getTime();

			// �������

			days = (int) ((back - borrow) / 1000 / 60 / 60 / 24);

			System.out.println("�������:" + days + "��");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return days;

	}

	// ����id����ͼ����Ϣ

	public Book findById(int id) {

		Book book = null;

		// �õ����ݿ�����
		Connection conn = DBConnection.getConnection();
		String sql = "select * from book where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			// ��ѯ�õ������

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

	// ����id�޸�ͼ����ϢΪ�黹

	public int updateById(int id) {

		int result = 0;

		// �õ����ݿ�����
		Connection conn = DBConnection.getConnection();

		String sql = "update book set borrow_date=?,user=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "��δ���");

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
