package com.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bean.Student;

//��xml�ļ��ж�ȡ��Ϣ
public class Demo1 {

	public static void main(String[] args) {
		// �������ϣ�����ѧ��������Ϣ

		List<Student> list_stus = new ArrayList<Student>();

		// ����SAXReader
		SAXReader sax = new SAXReader();

		// �����ļ�����

		File file = new File("student.xml");

		// �õ�Document����

		try {
			Document doc = sax.read(file);

			// �õ���Ԫ��

			Element ele_root = doc.getRootElement();

			System.out.println("��Ԫ��Ϊ��" + ele_root.getName());

			// ��ȡ��Ԫ�أ����ɼ���

			List<Element> list = ele_root.elements();

			// �������ϣ�ȡ����Ϣ

			for (Element element : list) {

				String sid = element.elementText("sid");

				String name = element.elementText("name");

				String sex = element.elementText("sex");

				String age = element.elementText("age");

				String hobby = element.elementText("hobby");

				// ����Student���󱣴�

				Student student = new Student(sid, name, sex, age, hobby);

				// ��ѧ��������Ϣ��ӽ�����
				list_stus.add(student);

			}

			// ����

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
