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

	// 保存所有bean信息

	private List<Bean> list = new ArrayList<Bean>();

	// 创建Map集合，根据id取出对象

	Map<String, Object> map = new HashMap<String, Object>();

	public Utils(String path) {
		this.path = path;

		// 解析xml，获取所有bean信息

		init_list();

		// 创建beans中的所有bean对象，放入Map集合，准备出数据

		init_obj();

	}

	// 解析xml，获取所有bean信息

	public void init_list() {

		file = new File(path);// 初始化文件对象

		// 创建SAXReader
		SAXReader sax = new SAXReader();

		// 创建文件
		File file = new File("Beans.xml");

		try {
			Document doc = sax.read(file);

			// 获取根元素

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

	// 反射创建对象

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

	// 创建beans中的所有bean对象，放入Map集合

	public void init_obj() {

		for (Bean bean : list) {

			String id = bean.getId();
			// 调用反射创建对象的方法

			Object obj = getObj(bean.getClazz());

			map.put(id, obj);

		}

	}

	// 根据id得到对象的方法

	public Object getBean(String id) {

		return map.get(id);

	}

}
