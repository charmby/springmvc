package com.gsafety.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsafety.po.Result;
import com.gsafety.po.User;
import com.gsafety.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;



@RestController
@RequestMapping("/user")
@Api(value = "用户管理界面", description = "有关于用户管理的操作", position = 1)  
public class UserController {
	private static Logger log2 = 	Logger.getLogger(UserController.class);
	@Resource
	private IUserService userService;

	@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/showUser", method = RequestMethod.GET, produces = "application/json")
	public 		User toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "用户Id") @RequestParam("id") Integer id,Model model){
		log2.error(id+"的查询结构！");
		
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		log2.info("返回user对象："+user.toString());
		return 		user;
	}
}
