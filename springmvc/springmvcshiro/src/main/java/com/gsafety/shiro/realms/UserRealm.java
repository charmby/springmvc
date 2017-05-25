package com.gsafety.shiro.realms;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.gsafety.po.User;
import com.gsafety.service.IPermissionService;
import com.gsafety.service.IRoleService;
import com.gsafety.service.IUserService;

public class UserRealm  extends AuthorizingRealm{

	@Resource(name="userService")
	private IUserService userService;
	
	
	@Resource(name="roleService")
	private IRoleService roleService;
	
	@Resource(name="permissionService")
	private IPermissionService permissionService;
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
	/** 
	 * 权限认证 
	 */  
	@Override  
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {  
		//获取登录时输入的用户名  
		String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();  
		//到数据库查是否有此对象  
		User user=userService.getUserByUserName(loginName);  
		if(user!=null){  
			//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
			SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  	
			/*            //用户的角色集合  
            info.setRoles(user.getRolesName());  
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
            List<Role> roleList=user.getRoleList();  
            for (Role role : roleList) {  
                info.addStringPermissions(role.getPermissionsName());  
            }  */
			
			
			return info;  
		}  
		return null;  
	}  

	/** 
	 * 登录认证; 
	 */  
	@Override  
	protected AuthenticationInfo doGetAuthenticationInfo(  
			AuthenticationToken authenticationToken) throws AuthenticationException {  
		//UsernamePasswordToken对象用来存放提交的登录信息  
		UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;  
		//查出是否有此用户  
		char[] pass= token.getPassword();
		if(pass!=null){
			User user=userService.getUserByUserNameAndPassword(token.getUsername(),String.valueOf(pass));  
			if(user!=null){  
				//若存在，将此用户存放到登录认证info中  
				//将正确的用户信息，请求登录用户的用户名和正确的密码，创建AuthenticationInfo对象并返回  
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());  
				return info;
			}  
		}

		return null;  
	}  


}
