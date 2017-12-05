package com.servlet;

//���Ʋ�
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ҵ�������

	UserService uservice = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// ��ֹ��������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username);
		System.out.println(password);

		// �������󱣴���Ϣ

		User user = new User(username, password);
		// ���õ�¼ҵ���ж��Ƿ��¼�ɹ�
		if (uservice.login(user)) {

			// ��¼�ɹ�

			HttpSession session=request.getSession();
			
			session.setAttribute("username", username);

			// ת������¼�ɹ�ҳ��

			request.getRequestDispatcher("listbook.do?page=1").forward(request,
					response);

		} else {

			// ��¼ʧ��

			// ת������¼ʧ��ҳ��

			request.getRequestDispatcher("WEB-INF/jsp/failed.jsp").forward(
					request, response);

		}

	}

}
