package com.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bean.Bean;

public class Utils {

	private String path;

	private File file;

	// ��������bean��Ϣ

	private List<Bean> list = new ArrayList<Bean>();

	// ����Map���ϣ�����idȡ������

	Map<String, Object> map = new HashMap<String, Object>();

	public Utils(String path) {
		this.path = path;

		// ����xml����ȡ����bean��Ϣ

		init_list();

		// ����beans�е�����bean���󣬷���Map���ϣ�׼��������

		init_obj();

	}

	// ����xml����ȡ����bean��Ϣ

	public void init_list() {

		file = new File(path);// ��ʼ���ļ�����

		// ����SAXReader
		SAXReader sax = new SAXReader();

		// �����ļ�
		File file = new File("Beans.xml");

		try {
			Document doc = sax.read(file);

			// ��ȡ��Ԫ��

			Element root_ele = doc.getRootElement();

			List<Element> bean_list = root_ele.elements("bean");

			for (Element element : bean_list) {

				String id = element.attributeValue("id");

				String clazz = element.attributeValue("class");

				Bean bean = new Bean(id, clazz);

				list.add(bean);
			}

			for (Bean bean : list) {

				System.out.println(bean.toString());
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ���䴴������

	public Object getObj(String clazz) {

		Object obj = null;

		try {
			Class cla = Class.forName(clazz);

			obj = cla.newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;

	}

	// ����beans�е�����bean���󣬷���Map����

	public void init_obj() {

		for (Bean bean : list) {

			String id = bean.getId();
			// ���÷��䴴������ķ���

			Object obj = getObj(bean.getClazz());

			map.put(id, obj);

		}

	}

	// ����id�õ�����ķ���

	public Object getBean(String id) {

		return map.get(id);

	}

}
