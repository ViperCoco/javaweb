package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.BookService;

/**
 * Servlet implementation class BorrowBookServlet
 */
@WebServlet("/borrow.do")
public class BorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService bservice = new BookService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowBookServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));

		int page = Integer.parseInt(request.getParameter("page"));

		// �޸�ͼ����Ϣ

		bservice.borrow_book(id, username);

		// ˢ��ҳ��

		request.getRequestDispatcher("listbook.do?page=" + page).forward(
				request, response);

	}

}
