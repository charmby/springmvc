package com.gsafety.po;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FormatModel {
	@ApiModelProperty(value="金额",example="12345.678",required=true)
	private double money;
	@ApiModelProperty(value="日期",required=true)
	private Date date;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

}
