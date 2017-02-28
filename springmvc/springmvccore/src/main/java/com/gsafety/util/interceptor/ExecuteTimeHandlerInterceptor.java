package com.gsafety.util.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 查看执行时间的拦截器
 * @author xiaodh
 *
 */
public class ExecuteTimeHandlerInterceptor implements HandlerInterceptor {
	private static Logger logger  = LoggerFactory.getLogger(LogHandlerInterceptorAdapter.class);
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("我进入了ExecuteTimeHandlerInterceptor拦截"+handler.getClass()+";执行时间："+new Date().toString());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("我进入了ExecuteTimeHandlerInterceptor拦截"+handler.getClass()+";执行时间："+new Date().toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		logger.debug("我进入了ExecuteTimeHandlerInterceptor拦截"+handler.getClass()+";执行时间："+new Date().toString());
	}

}
