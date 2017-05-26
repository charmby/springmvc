package com.gsafety.shiro.po;
/**
 * 表示拦截的URL和角色/权限之间的关系，多个角色/权限之间通过逗号分隔，此处还可以扩展其他的关系，另外可以加如available属性表示是否开启该拦截。
 * @author xiaodh
 * 2017年5月26日 上午8:31:54
 */
public class UrlFilter {
	private Long id;  
	private String name; //url名称/描述  
	private String url; //地址  
	private String roles; //所需要的角色，可省略  
	private String permissions; //所需要的权限，可省略  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
}
