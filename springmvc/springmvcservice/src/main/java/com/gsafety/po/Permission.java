package com.gsafety.po;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
/**
 * 权限对象
 * @author xiaodh
 * 2017年5月22日 下午6:21:45
 */
public class Permission implements Serializable {

	private static final long serialVersionUID = -1887442470035485663L;
	@ApiModelProperty(value = "权限Id", example = "1",position = 1)
    private Integer id;
	@ApiModelProperty(value = "权限名称", example = "admin",position = 3)
    private String permissionName;
	@ApiModelProperty(value = "密码",position = 2)
	private String permissionDesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionDesc() {
		return permissionDesc;
	}
	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	
}
