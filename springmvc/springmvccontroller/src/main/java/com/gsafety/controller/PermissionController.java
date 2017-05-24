package com.gsafety.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsafety.po.Permission;
import com.gsafety.service.IPermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;



@RestController
@RequestMapping("/permission")
@Api(value = "权限管理界面", description = "有关于权限信息管理的操作", position = 2)  
public class PermissionController{
	private static Logger log = 	Logger.getLogger(PermissionController.class);
	@Resource(name="permissionService")
	private IPermissionService permissionService;

	@ApiOperation(value = "根据权限信息id查询权限信息信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getPermissionById", method = RequestMethod.GET, produces = "application/json")
	public 		Permission toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "权限信息Id") @RequestParam("id") Integer id,Model model) throws Exception{
		log.error(id+"的查询结z构！");
		Permission permission = permissionService.getPermissionById(id);;
		model.addAttribute("permission", permission);
		log.info("返回permission对象："+permission.toString());
		
		return  permission;
	}



	@ApiOperation(value = "更新权限信息信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/updatePermission", method = RequestMethod.GET, produces = "application/json")
	public 		int updatePermission(HttpServletRequest request,Permission permission) throws Exception{
		int id =	permissionService.updateByPrimaryKeySelective(permission);
		return 		id;
	}


	@ApiOperation(value = "新增权限信息信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/insertPermission", method = RequestMethod.GET, produces = "application/json")
	public 		int insertPermission(HttpServletRequest request,Permission permission) throws Exception{
		int id = permissionService.insertSelective(permission);
		return 		id;
	}


	@ApiOperation(value = "删除权限信息信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/deletePermission", method = RequestMethod.GET, produces = "application/json")
	public 		int deletePermission(HttpServletRequest request,Integer permissionId) throws Exception{
		int id = permissionService.deleteByPrimaryKey(permissionId);
		return 	id;
	}
	
	
	@ApiOperation(value = "获得所有权限信息信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getAllPermission", method = RequestMethod.GET, produces = "application/json")
	public 		List<Permission> getAllPermission() throws Exception{
		List<Permission>  userList =permissionService.getAllPermission();
		return 		userList;
	}
	
	

}
