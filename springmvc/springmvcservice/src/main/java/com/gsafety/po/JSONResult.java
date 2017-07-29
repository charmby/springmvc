package com.gsafety.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "JSON返回结果信息")
public class JSONResult {
	@ApiModelProperty(value = "结果信息")
	private String message;
	@ApiModelProperty(value = "返回编码")
	private int code = -1;
	@ApiModelProperty(value = "消息编码")
	private String messageCode;
	@ApiModelProperty(value = "返回体信息")
	private Object body;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
