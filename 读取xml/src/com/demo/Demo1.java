package com.demo;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args) {
		// 1����dom4j��SAX����

		SAXReader sr = new SAXReader();

		try {

			// 2����xml�ļ���ȡdom4j��Document����
			Document document = sr.read(new File("student.xml"));

			// 3��ȡ��Ԫ��

			Element root_element = document.getRootElement();

			System.out.println("��Ԫ��Ϊ��" + root_element.getName());
			// 4��ȡ���е�student��Ԫ��

			List<Element> list = root_element.elements("student");

			// ������Ԫ��

			for (Element student : list) {

				// ��ȡstudent��Ԫ���µ��ı�����

				String sid = student.elementText("sid");
				String name = student.elementText("name");
				String sex = student.elementText("sex");
				String age = student.elementText("age");
				String hobby = student.elementText("hobby");

				System.out.println("���:" + sid);
				System.out.println("����:" + name);
				System.out.println("�Ա�:" + sex);
				System.out.println("����:" + age);
				System.out.println("����:" + hobby);
				System.out.println("====================");

			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
