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

public class BeanUtils {

	private String path;
	private File file;

	private List<Bean> list;

	private Map<String, Object> map;

	public BeanUtils(String path) {
		this.path = path;

		file = new File(path);

		// ����xml����ȡbean��Ϣ

		getBeans();

		// ����bean����������Ϣ

		createAllObj();

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	// ��ȡ����xml�е�����bean

	public void getBeans() {

		list = new ArrayList<Bean>();

		// 1����dom4j��SAX����

		SAXReader sr = new SAXReader();

		// 2����xml�ļ���ȡdom4j��Document����

		System.out.println("getBeans:" + file.getName());
		try {
			Document document = sr.read(file);

			// 3��ȡ��Ԫ��

			Element root_element = document.getRootElement();

			List<Element> bean_list = root_element.elements("bean");

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

	public Object getBean(String id) {

		Object obj = map.get(id);

		return obj;

	}

	// ����beans��������Ķ��󣬱����Map����

	public void createAllObj() {

		map = new HashMap<String, Object>();

		for (Bean bean : list) {

			String id = bean.getId();

			Object obj = createObj(bean.getClazz());

			map.put(id, obj);

		}

	}

	// ����bean�����е���Ϣ���䴴������

	public static Object createObj(String clazz) {

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

}
