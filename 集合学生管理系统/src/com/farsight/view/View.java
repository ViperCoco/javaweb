package com.farsight.view;

import java.util.List;
import java.util.Scanner;

import com.farsight.bean.Student;
import com.farsight.utils.Utils;

//视图
public class View {

	public Scanner input = new Scanner(System.in);

	public Utils utils = new Utils();

	public void menu() {

		System.out
				.println("----------------------------------欢迎使用-----------------------------------------");

		System.out.println("1.增加学生");

		System.out.println("2.删除学生");

		System.out.println("3.修改学生");

		System.out.println("4.查找学生");

		System.out.println("5.显示全部学生");

		System.out.println("0.退出");

		System.out.println("请选择：");

		int user_choose = input.nextInt();

		// 判断

		switch (user_choose) {
		case 1:

			// 从键盘输入学生信息

			System.out.println("请输入学生id：");

			String id_add = input.next();

			boolean can_add = utils.canAdd(id_add);

			if (can_add) {

				Student stu_add = getStudent(id_add);

				utils.addStu(stu_add);

				System.out.println("添加成功！");

			} else {

				System.out.println("学生编号重复！");
			}

			menu();

			break;

		case 2:

			System.out.println("请输入要删除的学生的编号：");

			String id_del = input.next();

			boolean result2 = utils.delById(id_del);

			if (result2) {

				System.out.println("删除成功！");

			} else {

				System.out.println("删除失败！学生不存在！");
			}

			menu();

			break;

		case 3:
			// 从键盘输入学生信息

			System.out.println("请输入要修改学生的id：");

			String id_update = input.next();

			boolean can_update = utils.canUpdate(id_update);

			if (can_update) {

				Student stu_update = getStudent(id_update);

				utils.Update(stu_update);

				System.out.println("修改成功！");

			} else {

				System.out.println("修改失败，学生不存在！");
			}

			menu();

		case 4:

			System.out.println("请输入要查找的学生的id：");

			String id_find = input.next();

			Student stu_find = utils.findById(id_find);

			if (stu_find != null) {

				showInfo(stu_find);

			} else {

				System.out.println("学生不存在！");
			}

			menu();

			break;

		case 5:

			// 拿到学生对象数组

			List<Student> list = utils.getAll();

			showInfo(list);// 调用显示学生信息的方法

			menu();

			break;

		case 0:

			System.out.println("系统已退出...");

			System.exit(0);// Java退出程序

			break;

		default:
			break;
		}

	}

	// 获取输入的学生信息

	// 无参有返回值的方法

	public Student getStudent(String id) {

		System.out.println("请输入学生的姓名:");

		String name = input.next();

		System.out.println("请输入学生的性别:");

		String sex = input.next();

		System.out.println("请输入学生的年龄:");

		int age = input.nextInt();

		System.out.println("请输入学生的爱好:");

		String hobby = input.next();

		// 创建学生对象

		Student student = new Student(id, name, sex, age, hobby);

		return student;

	}

	// 显示学生信息

	public void showInfo(List<Student> list) {

		System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t爱好");

		// for-each遍历数组
		for (Student student : list) {

			if (student != null) {

				System.out.println(student.getInfo());

			}

		}

	}

	public void showInfo(Student student) {

		System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t爱好");
		System.out.println(student.getInfo());

	}

}
