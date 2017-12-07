package com.bean;

public class Book {

	private int id;

	private String name;

	private double price;

	private String info;

	private String img_url;

	private String borrow_date;

	private String user;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, double price, String info, String img_url,
			String borrow_date, String user) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.info = info;
		this.img_url = img_url;
		this.borrow_date = borrow_date;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", info=" + info + ", img_url=" + img_url + ", borrow_date="
				+ borrow_date + ", user=" + user + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
