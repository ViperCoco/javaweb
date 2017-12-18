package com.test;

import org.junit.Test;

import com.bean.Book;
import com.bean.Student;
import com.utils.Utils;

public class TestDemo {

	@Test
	public void test1() {

		Utils utils = new Utils("beans.xml");

		Student stu1 = (Student) utils.getBean("student");

		Student stu2 = (Student) utils.getBean("student");
		
		Book book=(Book) utils.getBean("book");

		System.out.println(stu1.toString());

		System.out.println(stu2.toString());
		
		System.out.println(book.toString());

	}

}
