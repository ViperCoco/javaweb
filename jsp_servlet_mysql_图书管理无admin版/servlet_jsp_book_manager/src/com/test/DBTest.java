package com.test;

import java.util.List;

import org.junit.Test;

import com.bean.Book;
import com.dao.BookDao;

public class DBTest {

	BookDao bdao = new BookDao();

//	@Test
	public void limit() {

		List<Book> list = bdao.Limit("jack", -1, 3);

		for (Book book : list) {

			System.out.println(book.toString());
		}

	}
	@Test
	public void borrow(){
		
		
	System.out.println(	bdao.updateById(2, "Ð¡À¼"));
		
	}

}
