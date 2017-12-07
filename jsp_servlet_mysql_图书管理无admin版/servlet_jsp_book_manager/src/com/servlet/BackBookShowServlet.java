package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.service.BookService;

/**
 * Servlet implementation class BackBookShowServlet
 */
@WebServlet("/backbookshow.do")
public class BackBookShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService bservice = new BookService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackBookShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 得到登录的用户名

		HttpSession session = request.getSession();

		String username = session.getAttribute("username").toString();
		// 得到操作的图书编号

		int id = Integer.parseInt(request.getParameter("id"));

		// 得到第几页数据

		int back_page = Integer.parseInt(request.getParameter("back_page"));

		// 根据id得到图书信息

		Book book_back = bservice.findById(id);

		// 得到书名

		String book_name = book_back.getName();

		// 得到图书图片地址

		String img_url = book_back.getImg_url();

		// 得到借出日期

		String borrow_date = book_back.getBorrow_date();

		// 得到每日租金

		double price = book_back.getPrice();

		System.out.println("BackBookShowServlet:" + id);

		System.out.println("BackBookShowServlet:" + book_name);
		System.out.println("BackBookShowServlet:" + borrow_date);

		// 准备显示数据

		// 归还日期

		String back_date = bservice.getDate();

		/* 得到借出天数 */
		int days = bservice.getDays(borrow_date, back_date);
		// 得到租金

		double money = bservice.money(days, price);

		// 将页数保存进session

		session.setAttribute("back_page", back_page);

		// 归还图书

		bservice.back_book(id);

		// 转发到页面显示

		request.setAttribute("back_img", img_url);

		request.setAttribute("back_name", book_name);

		request.setAttribute("back_price", price);

		request.setAttribute("back_days", days);

		request.setAttribute("back_money", money);

		// 转发

		request.getRequestDispatcher("WEB-INF/jsp/back_book.jsp").forward(
				request, response);

	}

}
