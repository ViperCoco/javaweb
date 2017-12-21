package com.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bean.Student;

//从xml文件中读取信息
public class Demo1 {

	public static void main(String[] args) {
		// 创建集合，保存学生对象信息

		List<Student> list_stus = new ArrayList<Student>();

		// 创建SAXReader
		SAXReader sax = new SAXReader();

		// 创建文件对象

		File file = new File("student.xml");

		// 得到Document对象

		try {
			Document doc = sax.read(file);

			// 得到根元素

			Element ele_root = doc.getRootElement();

			System.out.println("根元素为：" + ele_root.getName());

			// 读取子元素，生成集合

			List<Element> list = ele_root.elements();

			// 遍历集合，取出信息

			for (Element element : list) {

				String sid = element.elementText("sid");

				String name = element.elementText("name");

				String sex = element.elementText("sex");

				String age = element.elementText("age");

				String hobby = element.elementText("hobby");

				// 创建Student对象保存

				Student student = new Student(sid, name, sex, age, hobby);

				// 将学生对象信息添加进集合
				list_stus.add(student);

			}

			// 遍历

			for (Student student : list_stus) {

				System.out.println(student.toString());

				System.out.println("---------------------------------");

			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
