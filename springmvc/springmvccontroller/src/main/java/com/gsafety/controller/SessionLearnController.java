package com.gsafety.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gsafety.po.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
/**
 * 在WEB开发中，服务器可以为每个用户浏览器创建一个会话对象（session对象），
 * 注意：一个浏览器独占一个session对象(默认情况下)。因此，在需要保存用户数据时，服务器程序可以把用户数据写到用户浏览器独占的session中，
 * 当用户使用浏览器访问其它程序时，其它程序可以从用户的session中取出该用户的数据，为用户服务。
 * @author xiaodh
 * 2017年6月22日 下午7:31:51
 */
@RestController
@RequestMapping("/sessionLearn")
@Api(value = "session学习界面", description = "有关于session知识的学习操作", position = 1)  
public class SessionLearnController {


	@ApiOperation(value = "第一次访问程序", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@RequestMapping(value = "/firstVisit", method = RequestMethod.GET, produces = "application/json")
	public void firstVisit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Map<String,String> map = new HashMap<String,String>();
		response.setCharacterEncoding("UTF=8");
		response.setContentType("text/html;charset=UTF-8");
		//使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		//将数据存储到session中
		session.setAttribute("data", "孤傲苍狼");
		//获取session的Id
		String sessionId = session.getId();
		//判断session是不是新创建的
		if (session.isNew()) {
			response.getWriter().print("session创建成功，session的id是："+sessionId);
		}else {
			response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
		}
	}


}
