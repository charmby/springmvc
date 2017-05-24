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

import com.gsafety.po.Role;
import com.gsafety.service.IRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;



@RestController
@RequestMapping("/role")
@Api(value = "橘色管理界面", description = "有关于角色管理的操作", position = 1)  
public class RoleController{
	private static Logger log = 	Logger.getLogger(RoleController.class);
	@Resource(name="roleService")
	private IRoleService roleService;

	@ApiOperation(value = "根据角色id查询角色信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getRoleById", method = RequestMethod.GET, produces = "application/json")
	public 		Role toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "角色Id") @RequestParam("id") Integer id,Model model) throws Exception{
		log.error(id+"的查询结z构！");
		Role role = this.roleService.getRoleById(id);
		model.addAttribute("role", role);
		log.info("返回role对象："+role.toString());
		
		return  role;
	}



	@ApiOperation(value = "更新角色信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/updateRole", method = RequestMethod.GET, produces = "application/json")
	public 		int updateRole(HttpServletRequest request,Role role) throws Exception{
		int id =	roleService.updateByPrimaryKeySelective(role);
		return 		id;
	}


	@ApiOperation(value = "新增角色信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/insertRole", method = RequestMethod.GET, produces = "application/json")
	public 		int insertRole(HttpServletRequest request,Role role) throws Exception{
		int id = roleService.insertSelective(role);
		return 		id;
	}


	@ApiOperation(value = "删除角色信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/deleteRole", method = RequestMethod.GET, produces = "application/json")
	public 		int deleteRole(HttpServletRequest request,Integer roleId) throws Exception{
		int id = roleService.deleteByPrimaryKey(roleId);
		return 	id;
	}
	
	
	@ApiOperation(value = "获得所有角色信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getAllRole", method = RequestMethod.GET, produces = "application/json")
	public 		List<Role> getAllRole() throws Exception{
		List<Role>  userList =roleService.getAllRole();
		return 		userList;
	}
	
	

}
