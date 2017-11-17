package com.farsight.utils;

import java.util.ArrayList;
import java.util.List;

import com.farsight.bean.Student;

//������
public class Utils {

	public List<Student> list = new ArrayList<Student>();

	// ����ѧ����Ϣ

	// �ж�ѧ������Ƿ��ظ�

	public boolean canAdd(String id) {

		// �Ӽ����в�����û���ظ���id

		// �жϼ�������������
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

	// �򼯺������ѧ����Ϣ

	public void addStu(Student student) {

		list.add(student);

	}

	// �Ӽ�����ɾ��ѧ����Ϣ

	public boolean delById(String id) {

		// �ж�ѧ���Ƿ����

		if (list.size() > 0) {

			for (Student student : list) {

				if (student.stuId.equals(id)) {

					// �Ӽ�����ɾ��

					list.remove(student);

					return true;

				}

			}

		} else {

			return false;

		}
		return false;

	}

	// �޸�ѧ����Ϣ

	// �ж�Ҫ�޸ĵ�ѧ����Ϣ�Ƿ����

	public boolean canUpdate(String id) {

		if (list.size() > 0) {

			for (Student student : list) {

				if (student.stuId.equals(id)) {

					// ��ԭ����ѧ����Ϣɾ��
					list.remove(student);

					return true;

				}

			}

		} else {

			return false;
		}
		return false;

	}

	// �޸�ѧ����Ϣ

	public void Update(Student student) {

		list.add(student);

	}

	// ����ѧ����Ϣ

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

	// ��ʾȫ��ѧ����Ϣ

	public List<Student> getAll() {

		return list;

	}

}
