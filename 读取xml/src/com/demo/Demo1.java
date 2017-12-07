package com.demo;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args) {
		// 1创建dom4j的SAX解析

		SAXReader sr = new SAXReader();

		try {

			// 2加载xml文件获取dom4j的Document对象
			Document document = sr.read(new File("student.xml"));

			// 3获取根元素

			Element root_element = document.getRootElement();

			System.out.println("根元素为：" + root_element.getName());
			// 4获取所有的student子元素

			List<Element> list = root_element.elements("student");

			// 遍历子元素

			for (Element student : list) {

				// 获取student子元素下的文本内容

				String sid = student.elementText("sid");
				String name = student.elementText("name");
				String sex = student.elementText("sex");
				String age = student.elementText("age");
				String hobby = student.elementText("hobby");

				System.out.println("编号:" + sid);
				System.out.println("姓名:" + name);
				System.out.println("性别:" + sex);
				System.out.println("年龄:" + age);
				System.out.println("爱好:" + hobby);
				System.out.println("====================");

			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
