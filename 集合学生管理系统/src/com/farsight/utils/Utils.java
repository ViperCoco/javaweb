package com.farsight.utils;

import java.util.ArrayList;
import java.util.List;

import com.farsight.bean.Student;

//工具类
public class Utils {

	public List<Student> list = new ArrayList<Student>();

	// 增加学生信息

	// 判断学生编号是否重复

	public boolean canAdd(String id) {

		// 从集合中查找有没有重复的id

		// 判断集合中有无数据
		if (list.size() > 0) {

			for (Student student : list) {

				if (student.stuId.equals(id)) {

					return false;

				}

			}

		} else {

			return true;
		}
		return true;

	}

	// 向集合中添加学生信息

	public void addStu(Student student) {

		list.add(student);

	}

	// 从集合中删除学生信息

	public boolean delById(String id) {

		// 判断学生是否存在

		if (list.size() > 0) {

			for (Student student : list) {

				if (student.stuId.equals(id)) {

					// 从集合中删除

					list.remove(student);

					return true;

				}

			}

		} else {

			return false;

		}
		return false;

	}

	// 修改学生信息

	// 判断要修改的学生信息是否存在

	public boolean canUpdate(String id) {

		if (list.size() > 0) {

			for (Student student : list) {

				if (student.stuId.equals(id)) {

					// 将原来的学生信息删除
					list.remove(student);

					return true;

				}

			}

		} else {

			return false;
		}
		return false;

	}

	// 修改学生信息

	public void Update(Student student) {

		list.add(student);

	}

	// 查找学生信息

	public Student findById(String id) {

		if (list.size() > 0) {

			for (Student student : list) {

				if (student.stuId.equals(id)) {

					return student;

				}

			}
		} else {

			return null;

		}

		return null;

	}

	// 显示全部学生信息

	public List<Student> getAll() {

		return list;

	}

}
