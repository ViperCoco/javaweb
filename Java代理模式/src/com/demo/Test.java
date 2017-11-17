package com.demo;

public class Test {

	public static void main(String[] args) {

		Italk people = new People("小明", "20");

		people.talk("编程");

		System.out.println("----------------------------------------------");

		TalkProxy talker = new TalkProxy(people);

		talker.talk("编程");

		talker.talk("编程", "独家记忆");

	}

}
