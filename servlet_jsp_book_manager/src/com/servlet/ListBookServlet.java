package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Book;
import com.service.BookService;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/listbook.do")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService bservice = new BookService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBookServlet() {
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
		//��ҳÿҳ��¼��
		
		int num=3;
		//�õ���ҳ�����ҳ����ÿҳ3������
		
				int PageNum=bservice.getMaxPage(username, num);
				
				
				//�õ������ҳ��
				
				int page=Integer.parseInt(request.getParameter("page"));
				
				//׼������
				List<Book> list = bservice.Limit(username, page, num);
				
		

		request.setAttribute("booklist", list);
		
		request.setAttribute("PageNum", PageNum);
		
		request.setAttribute("page", page);

		// ת��
		request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request,
				response);

	}

}
