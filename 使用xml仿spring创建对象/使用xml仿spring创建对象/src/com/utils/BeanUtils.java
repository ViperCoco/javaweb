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

		// 解析xml，获取bean信息

		getBeans();

		// 根据bean创建对象信息

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

	// 获取所有xml中的所有bean

	public void getBeans() {

		list = new ArrayList<Bean>();

		// 1创建dom4j的SAX解析

		SAXReader sr = new SAXReader();

		// 2加载xml文件获取dom4j的Document对象

		System.out.println("getBeans:" + file.getName());
		try {
			Document document = sr.read(file);

			// 3获取根元素

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

	// 创建beans中所有类的对象，保存进Map集合

	public void createAllObj() {

		map = new HashMap<String, Object>();

		for (Bean bean : list) {

			String id = bean.getId();

			Object obj = createObj(bean.getClazz());

			map.put(id, obj);

		}

	}

	// 根据bean对象中的信息反射创建对象

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
