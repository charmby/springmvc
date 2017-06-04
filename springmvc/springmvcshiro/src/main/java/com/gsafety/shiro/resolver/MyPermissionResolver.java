package com.gsafety.shiro.resolver;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
/**
 * 用于权限字符串的解析。默认的是WildcardPermissionResolver解析器。
 * @author xiaodh
 * 2017年6月4日 下午3:48:12
 */
public class MyPermissionResolver  implements PermissionResolver{

	@Override
	public Permission resolvePermission(String permissionString) {
		// TODO Auto-generated method stub
		return   new WildcardPermission(permissionString);
	}

}
