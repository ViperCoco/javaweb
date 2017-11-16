package com.demo;

public abstract class Boss {

	public abstract void notifyBoss();

	public void sendwork(Staff staff) {

		System.out.println("老板通知工作...");

		staff.work(this);

	}

	class Staff {

		public void work(Boss boss) {

			try {
				Thread.sleep(2000);

				boss.notifyBoss();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
