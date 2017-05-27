package com.gsafety.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsafety.po.UserRole;
import com.gsafety.service.IUserRoleService;



@RestController
@RequestMapping("/userRole")
@Api(value = "用户角色关系管理界面", description = "有关于角色管理的操作", position = 1)  
public class UserRoleController{
	private static Logger log = 	Logger.getLogger(UserRoleController.class);
	@Resource(name="userRoleService")
	private IUserRoleService userRoleService;

	@ApiOperation(value = "根据用户id查询用户角色关系列表信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getUserRoleByUserId", method = RequestMethod.GET, produces = "application/json")
	@RequiresPermissions("item:update")
	public 	List<UserRole> getUserRoleByUserId(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "用户Id值，int类型") @RequestParam("id") Integer id) throws Exception{
		log.error(id+"的查询结z构！");
		List<UserRole> role = this.userRoleService.selectByUserId(id);
		log.info("返回role对象："+role.toString());
		return  role;
	}

	@ApiOperation(value = "根据角色id查询用户角色关系列表信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getUserRoleByRoldId", method = RequestMethod.GET, produces = "application/json")
	public 	List<UserRole> getUserRoleByRoleId(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "角色Id") @RequestParam("id") Integer id) throws Exception{
		log.error(id+"的查询结z构！");
		List<UserRole> role = this.userRoleService.selectByRoleId(id);
		log.info("返回role对象："+role.toString());
		return  role;
	}
	
	@ApiOperation(value = "根据关系id查询用户角色关系信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getUserRoleById", method = RequestMethod.GET, produces = "application/json")
	public 		UserRole toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "关系Id") @RequestParam("id") Integer id) throws Exception{
		log.error(id+"的查询结z构！");
		UserRole role = this.userRoleService.selectByPrimaryKey(id);
		log.info("返回role对象："+role.toString());
		
		return  role;
	}


	@ApiOperation(value = "更新关系信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/updateUserRole", method = RequestMethod.GET, produces = "application/json")
	public 		int updateUserRole(HttpServletRequest request,UserRole role) throws Exception{
		int id =	userRoleService.updateByPrimaryKeySelective(role);
		return 		id;
	}


	@ApiOperation(value = "新增用户角色信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/insertUserRole", method = RequestMethod.GET, produces = "application/json")
	public 		int insertUserRole(HttpServletRequest request,UserRole role) throws Exception{
		int id = userRoleService.insertSelective(role);
		return 		id;
	}


	@ApiOperation(value = "删除用户角色信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/deleteUserRole", method = RequestMethod.GET, produces = "application/json")
	public 		int deleteUserRole(HttpServletRequest request,Integer id) throws Exception{
		return 	userRoleService.deleteByPrimaryKey(id);
	}
	
	
	@ApiOperation(value = "获得所有用户角色信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getAllUserRole", method = RequestMethod.GET, produces = "application/json")
	public 		List<UserRole> getAllUserRole() throws Exception{
		List<UserRole>  userList =userRoleService.getAllUserRole();
		return 		userList;
	}
	
}
