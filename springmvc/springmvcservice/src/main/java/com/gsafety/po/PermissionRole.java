package com.gsafety.po;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 权限角色表
 * @author xiaodh
 * 2017年5月22日 下午6:32:22
 */
public class PermissionRole implements Serializable{
	private static final long serialVersionUID = 5048469720892243585L;
	@ApiModelProperty(value = "关系Id", example = "1",position = 1)
    private Integer id;
	@ApiModelProperty(value = "角色Id", example = "2",position = 1)
	private Integer roleId;
	@ApiModelProperty(value = "权限Id", example = "3",position = 1)
	private Integer permitId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPermitId() {
		return permitId;
	}
	public void setPermitId(Integer permitId) {
		this.permitId = permitId;
	}

}
