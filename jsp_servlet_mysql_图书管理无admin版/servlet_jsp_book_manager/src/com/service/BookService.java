package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Book;
import com.dao.BookDao;

//ҵ���߼���
public class BookService {

	private BookDao bdao = new BookDao();

	public List<Book> listbook(String username) {

		List<Book> list = new ArrayList<Book>();

		list = bdao.findAll(username);

		return list;

	}

	// ��ҳ�õ�������ҳ

	public int getMaxPage(String username, int num) {

		return bdao.getMaxPage(username, num);

	}

	// ��ҳ����
	public List<Book> Limit(String username, int page, int num) {

		List<Book> list = new ArrayList<Book>();

		list = bdao.Limit(username, page, num);

		return list;

	}

	// ���ͼ��

	public int borrow_book(int id, String username) {

		int result = 0;

		result = bdao.updateById(id, username);

		return result;
	}

	// �������

	public int getDays(String borrow_time, String back_time) {

		int days = 0;

		days = bdao.getDays(borrow_time, back_time);

		return days;

	}

	// �������

	public double money(int days, double price) {

		double pay = 0.00;

		pay = price * days;

		return pay;

	}

	// ��õ�ǰ���ڵ��ַ���
	public String getDate() {

		return bdao.getDate();

	}

	// ����id�õ�ͼ����Ϣ
	public Book findById(int id) {

		Book book = null;
		book = bdao.findById(id);

		return book;

	}

	// �黹ͼ��

	public int back_book(int id) {

		int result = 0;

		result = bdao.updateById(id);

		return result;

	}

}
