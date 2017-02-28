package com.gsafety.po;

public class User {


	private  int userId;
	private String userName;
	private int age;

	public User(String userName, int age) {
		this.userName = userName;
		this.age = age;
	}
	public User(int userId, String userName, int age) {
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}
