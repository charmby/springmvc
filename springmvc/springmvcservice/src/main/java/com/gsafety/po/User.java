package com.gsafety.po;

import java.io.Serializable;
import java.util.List;

import com.gsafety.commonabstractclass.AbstractCommonAttr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户",parent= AbstractCommonAttr.class/*,value="用户信息"*/)
public class User extends AbstractCommonAttr implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4724893856269070082L;
	@ApiModelProperty(value = "用户Id", example = "1",position = 1)
	private Integer id;
	@ApiModelProperty(value = "姓名", example = "xiao",position = 3)
	private String userName;
	@ApiModelProperty(value = "密码",position = 2)
	private String password;
	@ApiModelProperty(value = "年龄", example = "2",position = 3)
	private Integer age;
	@ApiModelProperty(value = "手机号", example = "2",position = 4)
	private String phone;

	private List<Role> roleList;


	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}


	@Override
	public Integer getId() {
		return id;
	}
	public User(){

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
