package com.demo;

public class Test {

	public static void main(String[] args) {

		Italk people = new People("С��", "20");

		people.talk("���");

		System.out.println("----------------------------------------------");

		TalkProxy talker = new TalkProxy(people);

		talker.talk("���");

		talker.talk("���", "���Ҽ���");

	}

}
