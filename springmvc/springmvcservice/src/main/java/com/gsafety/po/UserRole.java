package com.gsafety.po;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户角色关系表
 * @author xiaodh
 * 2017年5月22日 下午6:19:08
 */
@ApiModel(description = "用户角色关系",value="用户角色关系信息")
public class UserRole implements Serializable{

	private static final long serialVersionUID = 5048469720892243585L;

	@ApiModelProperty(value = "关系Id", example = "1",position = 1)
    private Integer id;
	@ApiModelProperty(value = "角色Id", example = "2",position = 1)
	private String roleId;
	@ApiModelProperty(value = "用户Id", example = "3",position = 1)
	private String userId;
	
	public Integer getId() {
		return id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public void setId(Integer id) {
		this.id = id;
	}
	
}
