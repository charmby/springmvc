package com.gsafety.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogHandlerInterceptorAdapter extends HandlerInterceptorAdapter{
	private static Logger logger  = LoggerFactory.getLogger(LogHandlerInterceptorAdapter.class);
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	/*	Map<String, String[]> requ = request.getParameterMap();*/
		String msg ="请求："+request.getRequestURL()+ " 进入处理器"+handler.getClass();
		logger.debug(msg);
		return super.preHandle(request, response, handler);
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null){
			logger.debug("在LogHandlerInterceptorAdapter拦截器中执行完了"+handler.getClass()+"的拦截！对象为："+modelAndView.getViewName());
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		logger.debug("在LogHandlerInterceptorAdapter拦截器中执行完了"+handler.getClass()+"的拦截！对象为："+handler.getClass());
		super.afterCompletion(request, response, handler, ex);
	}
}
