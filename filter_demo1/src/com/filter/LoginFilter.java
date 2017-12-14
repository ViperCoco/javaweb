package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {
	// 销毁
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LoginFilter:destroy()");
	}

	// 对请求进行过滤处理
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub

		arg0.setCharacterEncoding("utf-8");

		arg1.setContentType("text/html; charset=UTF-8");

		arg1.setCharacterEncoding("utf-8");

		System.out.println("LoginFilter前:" + arg0.getAttribute("name"));

		arg2.doFilter(arg0, arg1);// 继续传递

		System.out.println("LoginFilter后:" + arg0.getAttribute("name"));

	}

	// 过滤器初始化方法，在过滤器初始化时调用
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("LoginFilter:init()");

	}

}
