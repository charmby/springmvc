package com.gsafety.shiro.realms;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.transaction.annotation.Transactional;

import com.gsafety.po.Permission;
import com.gsafety.po.PermissionRole;
import com.gsafety.po.Role;
import com.gsafety.po.User;
import com.gsafety.po.UserRole;
import com.gsafety.service.IPermissionRoleService;
import com.gsafety.service.IPermissionService;
import com.gsafety.service.IRoleService;
import com.gsafety.service.IUserRoleService;
import com.gsafety.service.IUserService;

@SuppressWarnings("deprecation")
public class CASRealm extends CasRealm {

	@Resource(name="userService")
	private IUserService userService;


	@Resource(name="roleService")
	private IRoleService roleService;

	@Resource(name="permissionService")
	private IPermissionService permissionService;


	@Resource(name="userRoleService")
	private IUserRoleService userRoleService;

	@Resource(name="permissionRoleService")
	private IPermissionRoleService permissionRoleService;
	/**
	 * 授权访问控制，用于对用户进行的操作进行人证授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		if(username!=null&&!username.equals("")){
			User user = userService.getUserByUserName(username);

			if (user != null) {
				SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
				// 设置用户的角色
				List<UserRole> roles = userRoleService.selectByUserId(user.getId());
				for(UserRole ur :roles){
					Integer roleId = ur.getRoleId();
					Role roleEntity = roleService.getRoleById(roleId);
					if (null != roleEntity)
						authorizationInfo.addRole(roleEntity.getRoleCode());

					// 设置用户对应的角色的权限集合
					List<PermissionRole> permissons;
					try {
						permissons = permissionRoleService.selectByRoleId(roleId);
						for (PermissionRole permissionRole : permissons) {
							if(permissionRole!=null){
								Integer permissionId = permissionRole.getPermissionId();
								if(permissionId!=null){
									Permission permission = permissionService.getPermissionById(permissionId);
									if(permission!=null){
										authorizationInfo.addStringPermission(permission.getPermissionCode());
									}
								}
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return authorizationInfo;
			}
		}
		return null;

	}

	/**
	 * 验证用户身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		AuthenticationInfo result =  super.doGetAuthenticationInfo(token);
		System.out.println("CasRealm中的"+"我的测试线程="+Thread.currentThread().getName()); 
		return result;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCachedKickoutInfo() {

	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
		clearAllCachedKickoutInfo();
	}
}