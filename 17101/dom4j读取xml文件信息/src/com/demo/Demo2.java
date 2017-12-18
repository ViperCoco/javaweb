package com.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bean.Student;

public class Demo2 {
	// 将信息写入xml文件

	public static void main(String[] args) {

		// 准备数据

		List<Student> list = new ArrayList<Student>();

		Student stu1 = new Student("1", "小张", "男", "21", "Python");

		Student stu2 = new Student("2", "小李", "男", "21", "C++");

		Student stu3 = new Student("3", "小丽", "女", "19", "Html5");

		list.add(stu1);

		list.add(stu2);

		list.add(stu3);
		/*
		 * 创建文件对象
		 */

		File file = new File("student2.xml");

		// 创建SAXReader对象

		SAXReader sax = new SAXReader();

		// 得到Document对象

		try {
			Document doc = sax.read(file);

			Element ele_root = doc.getRootElement();

			// 遍历数据源集合

			for (Student student : list) {

				// 添加student子元素

				Element ele_stu = ele_root.addElement("student");

				Element ele_sid = ele_stu.addElement("sid");

				ele_sid.addText(student.getSid());// 设置文本信息

				Element ele_name = ele_stu.addElement("name");

				ele_name.addText(student.getName());// 设置文本信息

				Element ele_sex = ele_stu.addElement("sex");

				ele_sex.addText(student.getSex());// 设置文本信息

				Element ele_age = ele_stu.addElement("age");

				ele_age.addText(student.getAge());// 设置文本信息

				Element ele_hobby = ele_stu.addElement("hobby");

				ele_hobby.addText(student.getHobby());// 设置文本信息

			}

			// 写出到xml文件

			// 得到文件字节输出流

			FileOutputStream fos = new FileOutputStream(file);

			// 字符输出流
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");

			doc.write(osw);

			// 关闭流

			osw.close();
			fos.close();
			System.out.println("文件写出完毕！");

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
