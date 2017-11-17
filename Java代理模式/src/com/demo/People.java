package com.demo;

public class People implements Italk {

	private String username;

	private String userage;

	public People(String username, String userage) {
		super();
		this.username = username;
		this.userage = userage;
	}

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserage() {
		return userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}

	@Override
	public void talk(String msg) {
		// TODO Auto-generated method stub

		System.out.println(msg + "!你好，姓名为：" + username + "年龄为：" + userage);

	}

}
