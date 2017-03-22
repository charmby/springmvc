package com.gsafety.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回结果")
public class Result {
	@ApiModelProperty(value = "结果编码", example = "")
	private int code;
	@ApiModelProperty(value = "用户信息")
	private User data;
	@ApiModelProperty(value = "消息记录", example = "")
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
