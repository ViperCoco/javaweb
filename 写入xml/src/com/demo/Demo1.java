package com.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args) {

		File file = new File("student.xml");

		// 1����dom4j��SAX����

		SAXReader sr = new SAXReader();

		try {
			Document document = sr.read(file);

			// ��ȡ��Ԫ��

			Element rootEle = document.getRootElement();

			// ����student�ڵ�

			Element stuEle = rootEle.addElement("student");

			// ΪstudentԪ�������Ԫ��

			Element sid = stuEle.addElement("sid");

			sid.setText("4");

			Element name = stuEle.addElement("name");

			name.setText("С��");

			Element sex = stuEle.addElement("sex");

			sex.setText("��");

			Element age = stuEle.addElement("age");

			age.setText("20");

			Element hobby = stuEle.addElement("hobby");

			hobby.setText("����");

			// �����ļ����������д������

			FileOutputStream fos = new FileOutputStream(file);

			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");

			document.write(osw);

			osw.flush();
			osw.close();
			fos.close();

			System.out.println("д����ϣ�");

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
