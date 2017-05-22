package com.gsafety.shiro.realms;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InitRealm {
	private static final transient Logger log = LoggerFactory.getLogger(InitRealm.class);
	/**
	 * 获得init管理的安全管理
	 * @return
	 */
	public static SecurityManager getShiroSecurityManagerExistIniFile(){
		log.debug("进入获取init配置文件的SecurityManager对象的方法");
		//1.获得init的配置。构建SecurityManager的工厂
		log.debug("1.获得init的配置。构建SecurityManager的工厂！");
		Factory<SecurityManager> factory =  getShiroSecurityManagerFactory();
		//2.在工厂里面获得安全管理对象
		log.debug("2.在工厂里面获得安全管理对象！");
		SecurityManager securityManager = factory.getInstance();
		//3.返回获得的对象
		log.debug("3.返回获得的对象！");
		return securityManager;
	}
	/**
	 * 获得init管理的安全管理
	 * @return
	 */
	public static Factory<SecurityManager> getShiroSecurityManagerFactory(){
		log.debug("进入获取init配置文件的SecurityManager对象的方法");
		//1.获得init的配置。构建SecurityManager的工厂
		log.debug("1.获得init的配置。构建SecurityManager的工厂！");
		return new IniSecurityManagerFactory("classpath:shiro.ini");
		
	}
}
