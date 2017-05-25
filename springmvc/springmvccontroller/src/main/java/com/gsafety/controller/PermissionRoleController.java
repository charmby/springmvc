package com.gsafety.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsafety.po.PermissionRole;
import com.gsafety.service.IPermissionRoleService;



@RestController
@RequestMapping("/permissionRole")
@Api(value = "角色权限关系管理界面", description = "有关于角色管理的操作", position = 1)  
public class PermissionRoleController{
	private static Logger log = 	Logger.getLogger(PermissionRoleController.class);
	@Resource(name="permissionRoleService")
	private IPermissionRoleService permissionRoleService;

	@ApiOperation(value = "根据权限id查询权限角色关系列表信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getPermissionRoleByPermissionId", method = RequestMethod.GET, produces = "application/json")
	public 	List<PermissionRole> getPermissionRoleByUserId(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "用户Id") @RequestParam("id") Integer id) throws Exception{
		log.error(id+"的查询结z构！");
		List<PermissionRole> role = this.permissionRoleService.selectByPermissionId(id);
		log.info("返回role对象："+role.toString());
		return  role;
	}

	@ApiOperation(value = "根据角色id查询权限角色关系列表信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getPermissionRoleByRoleId", method = RequestMethod.GET, produces = "application/json")
	public 	List<PermissionRole> getPermissionRoleByRoleId(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "角色Id") @RequestParam("id") Integer id) throws Exception{
		log.error(id+"的查询结z构！");
		List<PermissionRole> role = this.permissionRoleService.selectByRoleId(id);
		log.info("返回role对象："+role.toString());
		return  role;
	}
	
	@ApiOperation(value = "根据关系id查询权限角色关系信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getPermissionRoleById", method = RequestMethod.GET, produces = "application/json")
	public 		PermissionRole toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "关系Id") @RequestParam("id") Integer id) throws Exception{
		log.error(id+"的查询结z构！");
		PermissionRole role = this.permissionRoleService.selectByPrimaryKey(id);
		log.info("返回role对象："+role.toString());
		
		return  role;
	}


	@ApiOperation(value = "更新关系信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/updatePermissionRole", method = RequestMethod.GET, produces = "application/json")
	public 		int updatePermissionRole(HttpServletRequest request,PermissionRole role) throws Exception{
		int id =	permissionRoleService.updateByPrimaryKeySelective(role);
		return 		id;
	}


	@ApiOperation(value = "新增权限角色关系信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/insertPermissionRole", method = RequestMethod.GET, produces = "application/json")
	public 		int insertPermissionRole(HttpServletRequest request,PermissionRole role) throws Exception{
		int id = permissionRoleService.insertSelective(role);
		return 		id;
	}


	@ApiOperation(value = "删除权限角色关系信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/deletePermissionRole", method = RequestMethod.GET, produces = "application/json")
	public 		int deletePermissionRole(HttpServletRequest request,Integer id) throws Exception{
		return 	permissionRoleService.deleteByPrimaryKey(id);
	}
	
	
	@ApiOperation(value = "获得所有权限角色关系信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getAllPermissionRole", method = RequestMethod.GET, produces = "application/json")
	public 		List<PermissionRole> getAllPermissionRole() throws Exception{
		List<PermissionRole>  userList =permissionRoleService.getAllPermissionRole();
		return 		userList;
	}

}
