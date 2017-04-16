package com.gsafety.po;

import com.gsafety.commonabstractclass.AbstractCommonAttr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户",parent= AbstractCommonAttr.class/*,value="用户信息"*/)
public class User extends AbstractCommonAttr {
	@ApiModelProperty(value = "用户Id", example = "1",position = 1)
    private Integer id;
	@ApiModelProperty(value = "姓名", example = "xiao",position = 3)
    private String userName;
	@ApiModelProperty(value = "密码",position = 2)
    private String password;
    @ApiModelProperty(value = "年龄", example = "2",position = 2)
    private Integer age;
    @Override
	public Integer getId() {
		return id;
	}
	public User(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String password, Integer age) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
