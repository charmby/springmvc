package com.gsafety.bak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 用于测试拦截器是否能够使用
 * 
1、springfox首先扫描@RestController货@Controller注解，有这个注解的才是springmvc的类，才能扫描到springfox的ui中。
2. 然后springfox 扫描requestmapping中的value值，该值是请求url。

 * @author xiaodh
 *
 */
@Api(value = "测试API", description = "测试操作", position = 1)  
@RequestMapping(value = "/v2/api")
@RestController(value="/test")
public class TestInterceptController  implements Controller{
	@ApiOperation(value = "测试类中的一个测试API", notes = "测试API，返回modelandview")
	@ResponseBody
	@RequestMapping(value = "/test/{path}", method = RequestMethod.POST)
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("===========TestController");
		return new ModelAndView("test");
	}

}
