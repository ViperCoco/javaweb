package com.view;

import java.util.List;
import java.util.Scanner;

import com.bean.Student;
import com.utils.DBUtils;

//Cril+Shift+O���ٵ���

//��ͼ
public class View {

	public Scanner input = new Scanner(System.in);

	public DBUtils utils = new DBUtils();

	public void menu() {

		System.out
				.println("----------------------------------��ӭʹ��-----------------------------------------");

		System.out.println("1.����ѧ��");

		System.out.println("2.ɾ��ѧ��");

		System.out.println("3.�޸�ѧ��");

		System.out.println("4.����ѧ��");

		System.out.println("5.��ʾȫ��ѧ��");

		System.out.println("0.�˳�");

		System.out.println("��ѡ��");

		int user_choose = input.nextInt();

		// �ж�

		switch (user_choose) {
		case 1:

			// �Ӽ�������ѧ����Ϣ

			System.out.println("������ѧ��id��");

			int id_add = input.nextInt();

			Student stu = utils.findById(id_add);

			if (stu == null) {

				Student stu_add = getStudent(id_add);

				utils.add(stu_add);// ��ѧ����Ϣ��ӽ����ݿ�

				System.out.println("��ӳɹ���");

			} else {

				System.out.println("ѧ������ظ���");
			}

			menu();

			break;

		case 2:
			System.out.println("������Ҫɾ����ѧ����ţ�");

			int id_del = input.nextInt();

			Student stu_del = utils.findById(id_del);

			// ѧ�����ڣ������ɾ��
			if (stu_del != null) {

				utils.delById(id_del);

				System.out.println("ɾ���ɹ���");

			} else {

				System.out.println("ɾ��ʧ�ܣ�ѧ�������ڣ�");

			}

			menu();

			break;

		case 3:

			System.out.println("������Ҫ�޸ĵ�ѧ���ı��:");

			int id_update = input.nextInt();
			Student stu_update = utils.findById(id_update);
			if (stu_update != null) {
				Student up_stu = getStudent(id_update);
				utils.update(up_stu);
				System.out.println("�޸ĳɹ�");

			} else {
				System.out.println("�޸�ʧ�ܣ�ѧ�������ڣ�");
			}

			menu();

			break;

		case 4:

			System.out.println("������Ҫ���ҵ�ѧ����id��");

			int id_find = input.nextInt();

			Student stu_find = utils.findById(id_find);

			if (stu_find != null) {

				showInfo(stu_find);

			} else {

				System.out.println("ѧ�������ڣ�");
			}

			menu();

			break;

		case 5:

			// �õ�ѧ����������

			List<Student> list = utils.findAll();

			showInfo(list);// ������ʾѧ����Ϣ�ķ���

			menu();

			break;

		case 0:

			System.out.println("ϵͳ���˳�...");

			System.exit(0);// Java�˳�����

			break;

		default:
			break;
		}

	}

	// ��ȡ�����ѧ����Ϣ

	// �޲��з���ֵ�ķ���

	public Student getStudent(int id) {

		System.out.println("������ѧ��������:");

		String name = input.next();

		System.out.println("������ѧ�����Ա�:");

		String sex = input.next();

		System.out.println("������ѧ��������:");

		int age = input.nextInt();

		System.out.println("������ѧ���İ���:");

		String hobby = input.next();

		// ����ѧ������

		Student student = new Student(id, name, sex, age, hobby);

		return student;

	}

	// ��ʾѧ����Ϣ

	public void showInfo(List<Student> list) {

		System.out.println("���\t\t����\t\t�Ա�\t\t����\t\t����");

		// for-each��������
		for (Student student : list) {

			if (student != null) {

				System.out.println(student.toString());

			}

		}

	}

	public void showInfo(Student student) {

		System.out.println("���\t\t����\t\t�Ա�\t\t����\t\t����");
		System.out.println(student.toString());

	}

}
