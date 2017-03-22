package com.gsafety.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@ApiModel(description = "分页信息")
public class PageInfo {
	@ApiParam(value = "当前页", required = true)
	private Integer nowPage;
	
	@ApiModelProperty(value = "每页大小", required = true)
	private Integer pageSize;
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
