package com.gsafety.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.testng.Assert;

import com.gsafety.po.Result;
import com.gsafety.po.User;
import com.gsafety.service.IUserService;



@RestController
@RequestMapping("/user")
@Api(value = "用户管理界面", description = "有关于用户管理的操作", position = 1)  
public class UserController{
	private static Logger log = 	Logger.getLogger(UserController.class);
	@Resource(name="userService")
	private IUserService userService;

	@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "application/json")
	public 		User toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "用户Id") @RequestParam("id") Integer id) throws Exception{
		log.error(id+"的查询结z构！");

		AttributePrincipal principal = 	AssertionHolder.getAssertion().getPrincipal();
		if(principal!=null){
			String userName = principal.getName();
			System.out.println(userName);
		}
		User user = this.userService.getUserById(id);;

		return 		user;
	}


	@ApiOperation(value = "获得所有用户信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = "application/json")
	public 		List<User> getAllUser() throws Exception{
		List<User>  userList =userService.getAllUser();
		return 		userList;
	}

	@ApiOperation(value = "更新用户信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET, produces = "application/json")
	public 		int updateUser(HttpServletRequest request,User user) throws Exception{
		int id =	userService.updateByPrimaryKeySelective(user);
		return 		id;
	}


	@ApiOperation(value = "新增用户信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/insertUser", method = RequestMethod.GET, produces = "application/json")
	public 		int insertUser(HttpServletRequest request,User user) throws Exception{
		int id = userService.insertSelective(user);
		return 		id;
	}


	@ApiOperation(value = "删除用户信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET, produces = "application/json")
	public 		int deleteUser(HttpServletRequest request,Integer userId) throws Exception{
		int id = userService.deleteByPrimaryKey(userId);
		return 	id;
	}


	@ApiOperation(value = "获取shiro的登录信息", httpMethod = "POST", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public 		User login(Model model,HttpServletRequest request,@ApiParam(name = "userName", required = true, value = "用户名") @RequestParam("userName") String  userName,@ApiParam(name = "password", required = true, value = "密码") @RequestParam("password")String  password) throws Exception{
		    User user = null;
		    String msg = "";  
		    String result = "";
		    System.out.println(userName);  
		    System.out.println(password);   
		 // get the currently executing user:
			Subject currentUser = SecurityUtils.getSubject();
			
			// Do some stuff with a Session (no need for a web or EJB container!!!)
			Session session = currentUser.getSession();
			String value = (String) session.getAttribute("someKey");
			if (value!=null&&value.equals("aValue")) {
				log.info("Retrieved the correct value! [" + value + "]");
			}

			// let's login the current user so we can check against roles and permissions:
			if (!currentUser.isAuthenticated()) {
				UsernamePasswordToken token = new   UsernamePasswordToken(userName, password);
				//token.setRememberMe(true);
				
				session.setAttribute("someKey", "aValue");
				String value2 = (String) session.getAttribute("someKey");
				if (value2!=null&&value2.equals("aValue")) {
					log.info("Retrieved the correct value! [" + value2 + "]");
				}
				try {
					currentUser.login(token);
				} catch (IncorrectCredentialsException e) {  
			        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
			        model.addAttribute("message", msg);  
			        System.out.println(msg);  
			    } catch (ExcessiveAttemptsException e) {  
			        msg = "登录失败次数过多";  
			        model.addAttribute("message", msg);  
			        System.out.println(msg);  
			    } catch (LockedAccountException e) {  
			        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
			        model.addAttribute("message", msg);  
			        System.out.println(msg);  
			    } catch (DisabledAccountException e) {  
			        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
			        model.addAttribute("message", msg);  
			        System.out.println(msg);  
			    } catch (ExpiredCredentialsException e) {  
			        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
			        model.addAttribute("message", msg);  
			        System.out.println(msg);  
			    } catch (UnknownAccountException e) {  
			        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
			        model.addAttribute("message", msg);  
			        System.out.println(msg);  
			    } catch (UnauthorizedException e) {  
			        msg = "您没有得到相应的授权！" + e.getMessage();  
			        model.addAttribute("message", msg);  
			        System.out.println(msg);  
			    }  
			}
			//say who they are:
			//print their identifying principal (in this case, a username):
			log.info("User [" + currentUser.getPrincipal() + "] logged in successfully."); 
		      System.out.println(result);
		      return user;
	}
	
	@ApiOperation(value = "根据用户名获取用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/selectUserByUserName", method = RequestMethod.GET, produces = "application/json")
	public  User selectUserByUserName(String userName){
		User user = userService.getUserByUserName(userName);
		return user;
	}
	@ApiOperation(value = "退出系统",  produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/logout", produces = "application/json")
	public  String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println(currentUser);
		return "success";
	}
	
	@ApiOperation(value = "根据用户名和密码获取用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/showUserByUserNameAndPassWord", method = RequestMethod.GET, produces = "application/json")
	public 		User toIndex(HttpServletRequest request,@ApiParam(name = "username", required = true, value = "用户名") @RequestParam("username") String  username,@ApiParam(name = "password", required = true, value = "密码") @RequestParam("password")String  password) throws Exception{
		log.error("用户名："+username+"；密码："+password);
		User user2 = userService.selectByUserNameAndPasswordwhere(username,password);
		System.out.println(user2);
		User user = userService.getUserByUserNameAndPassword(username, password);
		
		System.out.println(user.toString());
		
		User user3 = userService.selectByUserNameAndPasswordByParam(username, password);
		
		System.out.println(user3.toString());
		
		// get the currently executing user:
		Subject currentUser = SecurityUtils.getSubject();
		
		// Do some stuff with a Session (no need for a web or EJB container!!!)
		Session session = currentUser.getSession();
		
		session.setAttribute("someKey", "aValue");
		String value = (String) session.getAttribute("someKey");
		if (value.equals("aValue")) {
			log.info("Retrieved the correct value! [" + value + "]");
		}

		// let's login the current user so we can check against roles and permissions:
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new   UsernamePasswordToken(username, password);
			//token.setRememberMe(true);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				log.info("There is no user with username of " + token.getPrincipal());
			} catch (IncorrectCredentialsException ice) {
				log.info("Password for account " + token.getPrincipal() + " was incorrect!");
			} catch (LockedAccountException lae) {
				log.info("The account for username " + token.getPrincipal() + " is locked.  " +
						"Please contact your administrator to unlock it.");
			}
			catch (AuthenticationException ae) {
				//unexpected condition?  error?
			}
		}
		//say who they are:
		//print their identifying principal (in this case, a username):
		log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

		//subject检查角色
		currentUser.checkPermission("lightsaber:weild");

		//判断拥有权限：user:create  
		Assert.assertTrue(currentUser.isPermitted("user:create"));  
		//判断拥有权限：user:update and user:delete  
		Assert.assertTrue(currentUser.isPermittedAll("user:update", "user:delete"));  
		//判断没有权限：user:view  
		Assert.assertFalse(currentUser.isPermitted("user:view"));  



		//断言拥有权限：user:create  
		currentUser.checkPermission("user:create");  
		//断言拥有权限：user:delete and user:update  
		currentUser.checkPermissions("user:delete", "user:update");  
		//断言拥有权限：user:view 失败抛出异常  
		currentUser.checkPermissions("user:view");  


		//判断subject的角色:
		if (currentUser.hasRole("schwartz")) {
			log.info("May the Schwartz be with you!");
		} else {
			log.info("Hello, mere mortal.");
		}

		//判断subject的权限
		if (currentUser.isPermitted("lightsaber:weild")) {
			log.info("You may use a lightsaber ring.  Use it wisely.");
		} else {
			log.info("Sorry, lightsaber rings are for schwartz masters only.");
		}

		//a (very powerful) Instance Level permission:
		if (currentUser.isPermitted("winnebago:drive:eagle5")) {
			log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
					"Here are the keys - have fun!");
		} else {
			log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
		}

		currentUser.logout();
		
		return  new User(username, password, 12);
	}

}
