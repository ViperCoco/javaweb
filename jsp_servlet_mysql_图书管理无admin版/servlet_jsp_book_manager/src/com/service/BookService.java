package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Book;
import com.dao.BookDao;

//业务逻辑层
public class BookService {

	private BookDao bdao = new BookDao();

	public List<Book> listbook(String username) {

		List<Book> list = new ArrayList<Book>();

		list = bdao.findAll(username);

		return list;

	}

	// 分页得到共多少页

	public int getMaxPage(String username, int num) {

		return bdao.getMaxPage(username, num);

	}

	// 分页数据
	public List<Book> Limit(String username, int page, int num) {

		List<Book> list = new ArrayList<Book>();

		list = bdao.Limit(username, page, num);

		return list;

	}

	// 借出图书

	public int borrow_book(int id, String username) {

		int result = 0;

		result = bdao.updateById(id, username);

		return result;
	}

	// 借出天数

	public int getDays(String borrow_time, String back_time) {

		int days = 0;

		days = bdao.getDays(borrow_time, back_time);

		return days;

	}

	// 计算租金

	public double money(int days, double price) {

		double pay = 0.00;

		pay = price * days;

		return pay;

	}

	// 获得当前日期的字符串
	public String getDate() {

		return bdao.getDate();

	}

	// 根据id得到图书信息
	public Book findById(int id) {

		Book book = null;
		book = bdao.findById(id);

		return book;

	}

	// 归还图书

	public int back_book(int id) {

		int result = 0;

		result = bdao.updateById(id);

		return result;

	}

}
