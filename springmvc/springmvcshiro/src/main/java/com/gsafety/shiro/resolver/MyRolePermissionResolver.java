package com.gsafety.shiro.resolver;

import java.util.Arrays;
import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * RolePermissionResolver用于根据角色字符串来解析得到权限集合。
 * @author xiaodh
 * 2017年6月4日 下午3:29:03
 */
public class MyRolePermissionResolver implements RolePermissionResolver{

	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
/*		  if("role1".equals(roleString)) {  
	            return Arrays.asList((Permission)new WildcardPermission("menu:*"));  
	        }  */
	        return null;  
	}

}
