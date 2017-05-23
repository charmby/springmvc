package com.gsafety.po;

import java.io.Serializable;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "角色",value="角色信息")
public class Role implements Serializable {
	private static final long serialVersionUID = -1887442470035485663L;
	@ApiModelProperty(value = "角色Id", example = "1",position = 1)
    private Integer id;
	@ApiModelProperty(value = "角色名称", example = "admin",position = 3)
    private String roleName;
	@ApiModelProperty(value = "角色编码",position = 2)
	private String roleCode;
	@ApiModelProperty(value = "角色描述",position = 2)
	private String roleDesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
