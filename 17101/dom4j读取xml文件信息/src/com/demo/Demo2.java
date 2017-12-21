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
	// ����Ϣд��xml�ļ�

	public static void main(String[] args) {

		// ׼������

		List<Student> list = new ArrayList<Student>();

		Student stu1 = new Student("1", "С��", "��", "21", "Python");

		Student stu2 = new Student("2", "С��", "��", "21", "C++");

		Student stu3 = new Student("3", "С��", "Ů", "19", "Html5");

		list.add(stu1);

		list.add(stu2);

		list.add(stu3);
		/*
		 * �����ļ�����
		 */

		File file = new File("student2.xml");

		// ����SAXReader����

		SAXReader sax = new SAXReader();

		// �õ�Document����

		try {
			Document doc = sax.read(file);

			Element ele_root = doc.getRootElement();

			// ��������Դ����

			for (Student student : list) {

				// ���student��Ԫ��

				Element ele_stu = ele_root.addElement("student");

				Element ele_sid = ele_stu.addElement("sid");

				ele_sid.addText(student.getSid());// �����ı���Ϣ

				Element ele_name = ele_stu.addElement("name");

				ele_name.addText(student.getName());// �����ı���Ϣ

				Element ele_sex = ele_stu.addElement("sex");

				ele_sex.addText(student.getSex());// �����ı���Ϣ

				Element ele_age = ele_stu.addElement("age");

				ele_age.addText(student.getAge());// �����ı���Ϣ

				Element ele_hobby = ele_stu.addElement("hobby");

				ele_hobby.addText(student.getHobby());// �����ı���Ϣ

			}

			// д����xml�ļ�

			// �õ��ļ��ֽ������

			FileOutputStream fos = new FileOutputStream(file);

			// �ַ������
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");

			doc.write(osw);

			// �ر���

			osw.close();
			fos.close();
			System.out.println("�ļ�д����ϣ�");

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
