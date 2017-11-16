package com.demo;

public class Factory {

	public static ICreate creator(String type) {

		if ("car".equals(type)) {

			return new CarCreate();

		} else if ("food".equals(type)) {

			return new FoodCreate();

		}

		return null;

	}

}
