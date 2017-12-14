package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter2 implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("LoginFilter2:destroy()");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		arg0.setCharacterEncoding("utf-8");

		arg1.setContentType("text/html; charset=UTF-8");

		arg1.setCharacterEncoding("utf-8");

		System.out.println("LoginFilter2前:" + arg0.getAttribute("name"));

		arg2.doFilter(arg0, arg1);// 继续传递
		
		System.out.println("LoginFilter2后:" + arg0.getAttribute("name"));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoginFilter2:init()");
	}

}
