package com.demo;

public class TalkProxy implements Italk {

	Italk talker;

	public TalkProxy(Italk talker) {
		super();
		this.talker = talker;
	}

	@Override
	public void talk(String msg) {
		// TODO Auto-generated method stub

		talker.talk(msg);

	}

	public void talk(String msg, String singname) {
		// TODO Auto-generated method stub

		talker.talk(msg);

		sing(singname);

	}

	private void sing(String singname) {

		System.out.println("³ª¸è£º" + singname);
	}

}
