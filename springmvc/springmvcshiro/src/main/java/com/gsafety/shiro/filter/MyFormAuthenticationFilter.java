package com.gsafety.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
	   private static final Logger log = LoggerFactory.getLogger(MyFormAuthenticationFilter.class);
	/**
	 * 需要覆盖shiro自己提供的 设置登录页面的方法
	 */
    private String loginUrl = DEFAULT_LOGIN_URL;
    
    @Override
    public String getLoginUrl() {
        return loginUrl;
    }
    /**
     * Sets the login URL used to authenticate a user.
     * <p/>
     * Most Shiro filters use this url as the location to redirect a user when the filter requires
     * authentication.  Unless overridden, the {@link #DEFAULT_LOGIN_URL DEFAULT_LOGIN_URL} is assumed.
     *
     * @param loginUrl the login URL used to authenticate a user, used when redirecting users if authentication is required.
     */
/*    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }*/
    
    @Override
    public void setLoginUrl(String loginUrl) {
        String previous = getLoginUrl();
        if (previous != null) {
            this.appliedPaths.remove(previous);
        }
        super.setLoginUrl(loginUrl);
        if (log.isTraceEnabled()) {
            log.trace("Adding login url to applied paths.");
        }
        this.appliedPaths.put(getLoginUrl(), null);
    }
}
