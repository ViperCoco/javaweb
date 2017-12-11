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

		// 1创建dom4j的SAX解析

		SAXReader sr = new SAXReader();

		try {
			Document document = sr.read(file);

			// 获取根元素

			Element rootEle = document.getRootElement();

			// 创建student节点

			Element stuEle = rootEle.addElement("student");

			// 为student元素添加子元素

			Element sid = stuEle.addElement("sid");

			sid.setText("4");

			Element name = stuEle.addElement("name");

			name.setText("小王");

			Element sex = stuEle.addElement("sex");

			sex.setText("男");

			Element age = stuEle.addElement("age");

			age.setText("20");

			Element hobby = stuEle.addElement("hobby");

			hobby.setText("篮球");

			// 创建文件输出流对象，写出数据

			FileOutputStream fos = new FileOutputStream(file);

			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");

			document.write(osw);

			osw.flush();
			osw.close();
			fos.close();

			System.out.println("写入完毕！");

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
