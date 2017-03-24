package com.gsafety.po;

import com.gsafety.commonabstractclass.AbstractCommonAttr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户",parent= AbstractCommonAttr.class/*,value="用户信息"*/)
public class User extends AbstractCommonAttr {

	@ApiModelProperty(value = "用户Id", example = "1",position = 1)
	private  int userId;
	@ApiModelProperty(value = "姓名", example = "xiao",position = 3)
	private String userName;
	@ApiModelProperty(value = "年龄", example = "2",position = 2)
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
