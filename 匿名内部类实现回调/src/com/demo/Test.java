package com.demo;

public class Test {

	public static void main(String[] args) {

		Boss boss = new Boss() {

			@Override
			public void notifyBoss() {
				// TODO Auto-generated method stub

				System.out.println("Ա�����������...");

			}
		};

		boss.sendwork(boss.new Staff());

	}

}
