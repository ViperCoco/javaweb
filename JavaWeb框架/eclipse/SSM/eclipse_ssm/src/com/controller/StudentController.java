package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Student;
import com.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Resource
	private StudentServiceImpl stuservice;

	@RequestMapping(value = "/listAll.do")
	public String listAll(HttpSession session, HttpServletRequest request) {

		List<Student> list = stuservice.findAll();

		// 如果没有数据，跳转到添加页面

		if (list != null && list.size() > 0) {


			request.setAttribute("stulist", list);

		}

		return "listAll";

	}

}
