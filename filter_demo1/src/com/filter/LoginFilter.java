package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {
	// ����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LoginFilter:destroy()");
	}

	// ��������й��˴���
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub

		arg0.setCharacterEncoding("utf-8");

		arg1.setContentType("text/html; charset=UTF-8");

		arg1.setCharacterEncoding("utf-8");

		System.out.println("LoginFilterǰ:" + arg0.getAttribute("name"));

		arg2.doFilter(arg0, arg1);// ��������

		System.out.println("LoginFilter��:" + arg0.getAttribute("name"));

	}

	// ��������ʼ���������ڹ�������ʼ��ʱ����
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("LoginFilter:init()");

	}

}
