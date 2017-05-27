package com.gsafety.po;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 权限对象
 * @author xiaodh
 * 2017年5月22日 下午6:21:45
 */
@ApiModel(description = "权限",value="权限信息")
public class Permission implements Serializable {

	private static final long serialVersionUID = -1887442470035485663L;
	@ApiModelProperty(value = "权限Id", example = "1",position = 1)
    private Integer id;
	@ApiModelProperty(value = "权限名称", example = "admin",position = 2)
    private String permissionName;
	@ApiModelProperty(value = "权限编码", example = "",position = 3)
    private String permissionCode;
	@ApiModelProperty(value = "权限url", example = "",position = 4)
    private String permissionUrl;
	@ApiModelProperty(value = "权限描述",position = 3)
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
	public String getPermissionCode() {
		return permissionCode;
	}
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
	public String getPermissionUrl() {
		return permissionUrl;
	}
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	
}