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
		// �õ���¼���û���

		HttpSession session = request.getSession();

		String username = session.getAttribute("username").toString();
		// �õ�������ͼ����

		int id = Integer.parseInt(request.getParameter("id"));

		// �õ��ڼ�ҳ����

		int back_page = Integer.parseInt(request.getParameter("back_page"));

		// ����id�õ�ͼ����Ϣ

		Book book_back = bservice.findById(id);

		// �õ�����

		String book_name = book_back.getName();

		// �õ�ͼ��ͼƬ��ַ

		String img_url = book_back.getImg_url();

		// �õ��������

		String borrow_date = book_back.getBorrow_date();

		// �õ�ÿ�����

		double price = book_back.getPrice();

		System.out.println("BackBookShowServlet:" + id);

		System.out.println("BackBookShowServlet:" + book_name);
		System.out.println("BackBookShowServlet:" + borrow_date);

		// ׼����ʾ����

		// �黹����

		String back_date = bservice.getDate();

		/* �õ�������� */
		int days = bservice.getDays(borrow_date, back_date);
		// �õ����

		double money = bservice.money(days, price);

		// ��ҳ�������session

		session.setAttribute("back_page", back_page);

		// �黹ͼ��

		bservice.back_book(id);

		// ת����ҳ����ʾ

		request.setAttribute("back_img", img_url);

		request.setAttribute("back_name", book_name);

		request.setAttribute("back_price", price);

		request.setAttribute("back_days", days);

		request.setAttribute("back_money", money);

		// ת��

		request.getRequestDispatcher("WEB-INF/jsp/back_book.jsp").forward(
				request, response);

	}

}
