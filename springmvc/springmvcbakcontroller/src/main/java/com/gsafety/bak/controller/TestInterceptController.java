package com.gsafety.bak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import io.swagger.annotations.Api;
/**
 * 用于测试拦截器是否能够使用
 * @author xiaodh
 *
 */
@Api(value = "测试API", description = "测试操作", position = 1)  
@RequestMapping(value = "/v2/api")
@RestController(value="/test")
public class TestInterceptController  implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("===========TestController");
		return new ModelAndView("test");
	}

}
