package com.gsafety.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 用于测试拦截器是否能够使用
 * @author xiaodh
 *
 */
public class TestInterceptController  implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("===========TestController");
		return new ModelAndView("test");
	}

}
