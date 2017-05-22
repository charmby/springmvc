package com.gsafety.shiro.api;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalMap;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gsafety.shiro.cons.ShiroInUseCons;
import com.gsafety.shiro.realms.InitRealm;

public class ShiroApiUtil {
	private static final transient Logger log = LoggerFactory.getLogger(ShiroApiUtil.class);
	/**
	 * 获得init管理的安全管理
	 * type  获得Realm的来源 类型 db 数据库; ini：ini文件;
	 * @return
	 */
	public static SecurityManager getShiroSecurityManagerExistIniFile(String type){
		log.debug("进入获取init配置文件的SecurityManager对象的方法");
		//1.获得init的配置。构建SecurityManager的工厂
		log.debug("1.获得init的配置。构建SecurityManager的工厂！");
		Factory<SecurityManager> factory = null;
		SecurityManager securityManager = null;
		if(type!=null ){
			if(type.equalsIgnoreCase(ShiroInUseCons.APP_REAMLE_DB)){

			}else if (type.equalsIgnoreCase(ShiroInUseCons.APP_REAMLE_INI)){
				factory = InitRealm.getShiroSecurityManagerFactory();
			}else{
				factory = InitRealm.getShiroSecurityManagerFactory();
			}

			//2.在工厂里面获得安全管理对象
			log.debug("2.在工厂里面获得安全管理对象！");
			securityManager = factory.getInstance();
			//3.返回获得的对象
			log.debug("3.返回获得的对象！");


		}
		return securityManager;

	}

	/**
	 * 判断 判断此Realm是否支持此Token   
	 * @param token
	 * @return
	 */
	public boolean supports(AuthenticationToken token) {  
		//仅支持UsernamePasswordToken类型的Token  
		return token instanceof UsernamePasswordToken;   
	}  
	public AuthenticationInfo getAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {  
		/*	        String username = (String)token.getPrincipal();  //得到用户名  
	        String password = new String((char[])token.getCredentials()); //得到密码  
		 */ 
		//如果身份认证验证成功，返回一个AuthenticationInfo实现；  
		return new AuthenticationInfo() {

			@Override
			public PrincipalCollection getPrincipals() {
				SimplePrincipalMap map = new SimplePrincipalMap();
				map.put("1",token.getPrincipal());
				return map;
			}

			@Override
			public Object getCredentials() {
				// TODO Auto-generated method stub
				return token.getCredentials();
			}
		};  
	}  
}
