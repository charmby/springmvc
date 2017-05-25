package com.gsafety.shiro.filter;


import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
	   private static final Logger log = LoggerFactory.getLogger(MyFormAuthenticationFilter.class);
	/**
	 * 需要覆盖shiro自己提供的 设置登录页面的方法
	 */
    private String loginRequest ;
    
    public String getLoginRequest() {
		return loginRequest;
	}
	public void setLoginRequest(String loginRequest) {
		this.loginRequest = loginRequest;
	}
     
}
