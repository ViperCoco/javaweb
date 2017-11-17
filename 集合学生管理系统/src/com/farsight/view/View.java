package com.farsight.view;

import java.util.List;
import java.util.Scanner;

import com.farsight.bean.Student;
import com.farsight.utils.Utils;

//��ͼ
public class View {

	public Scanner input = new Scanner(System.in);

	public Utils utils = new Utils();

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

			String id_add = input.next();

			boolean can_add = utils.canAdd(id_add);

			if (can_add) {

				Student stu_add = getStudent(id_add);

				utils.addStu(stu_add);

				System.out.println("��ӳɹ���");

			} else {

				System.out.println("ѧ������ظ���");
			}

			menu();

			break;

		case 2:

			System.out.println("������Ҫɾ����ѧ���ı�ţ�");

			String id_del = input.next();

			boolean result2 = utils.delById(id_del);

			if (result2) {

				System.out.println("ɾ���ɹ���");

			} else {

				System.out.println("ɾ��ʧ�ܣ�ѧ�������ڣ�");
			}

			menu();

			break;

		case 3:
			// �Ӽ�������ѧ����Ϣ

			System.out.println("������Ҫ�޸�ѧ����id��");

			String id_update = input.next();

			boolean can_update = utils.canUpdate(id_update);

			if (can_update) {

				Student stu_update = getStudent(id_update);

				utils.Update(stu_update);

				System.out.println("�޸ĳɹ���");

			} else {

				System.out.println("�޸�ʧ�ܣ�ѧ�������ڣ�");
			}

			menu();

		case 4:

			System.out.println("������Ҫ���ҵ�ѧ����id��");

			String id_find = input.next();

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

			List<Student> list = utils.getAll();

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

	public Student getStudent(String id) {

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

				System.out.println(student.getInfo());

			}

		}

	}

	public void showInfo(Student student) {

		System.out.println("���\t\t����\t\t�Ա�\t\t����\t\t����");
		System.out.println(student.getInfo());

	}

}
