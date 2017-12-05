package com.service;

import java.util.ArrayList;
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

}
