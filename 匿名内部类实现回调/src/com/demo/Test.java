package com.demo;

public class Test {

	public static void main(String[] args) {

		Boss boss = new Boss() {

			@Override
			public void notifyBoss() {
				// TODO Auto-generated method stub

				System.out.println("员工工作完成了...");

			}
		};

		boss.sendwork(boss.new Staff());

	}

}
