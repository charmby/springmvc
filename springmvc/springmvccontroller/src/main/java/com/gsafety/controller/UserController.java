package com.gsafety.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.testng.Assert;

import com.gsafety.po.Result;
import com.gsafety.po.Student;
import com.gsafety.po.User;
import com.gsafety.service.IUserService;
import com.gsafety.shiro.api.ShiroApiUtil;
import com.gsafety.shiro.cons.ShiroInUseCons;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;



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
	@RequestMapping(value = "/showUser", method = RequestMethod.GET, produces = "application/json")
	public 		User toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "用户Id") @RequestParam("id") Integer id,Model model) throws Exception{
		log.error(id+"的查询结z构！");
		/*
 //也可以通过request的方式获得id值
		int userId = Integer.parseInt(request.getParameter("id"));*/

		AttributePrincipal principal = 	AssertionHolder.getAssertion().getPrincipal();
		if(principal!=null){
			String userName = principal.getName();
			System.out.println(userName);
		}
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		log.info("返回user对象："+user.toString());
		showClassLoader();
		getResource();
		getResourceLoad();
		demoForSerializable();
		/*		ApplicationContext WebApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		MathUtils applicationname =(MathUtils) WebApplicationContext.getBean("mathUtils");
		applicationname.add(2, 2);*/
		/*		Properties properties = 	System.getProperties();
		if(properties!=null){
			Set set = 	properties.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {  
				String str = (String) it.next();
				System.out.println(str);
				System.out.println(properties.getProperty(str));  
			}  
		}*/
		return 		user;
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
	
	
	
	
	
	private void showClassLoader(){
		ClassLoader cloader = Thread.currentThread().getContextClassLoader();
		System.out.println(cloader);
		System.out.println(cloader.getParent());


		System.out.println(cloader.getParent().getParent());
	}

	private  void getResource (){
		org.springframework.core.io.Resource resource = new ClassPathResource("messages.properties");
		System.out.println(resource);
		try {
			File file = 	resource.getFile();
			System.out.println(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private  void getResourceLoad () throws IOException{

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		org.springframework.core.io.Resource  resources [] = resolver.getResources("classpath*:com/gsafety/**/*.xml");
		for(org.springframework.core.io.Resource  re :resources ){
			try {
				File file = 	re.getFile();
				System.out.println(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void demoForSerializable(){
		Student stu=new Student("Mike", "male", 22);
		if(stu instanceof Serializable){
			System.out.println(stu);
		}
		serialize("C:\\student.dat", stu);

		System.out.println("序列化完毕");
		Student stu1=deserialize("C:\\student.dat");
		System.out.println(stu1.getSname()+"\t"+stu1.getSex()+"\t"+stu1.getAge());
		System.out.println("反序列化完毕");
	}

	public static void serialize(String filename,Student stu){
		try {
			FileOutputStream fout=new FileOutputStream(filename);
			ObjectOutputStream oout =new ObjectOutputStream(fout);
			oout.writeObject(stu);
			oout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Student deserialize(String filename){
		try {
			FileInputStream fin=new FileInputStream(filename);
			ObjectInputStream oin=new ObjectInputStream(fin);
			Student stu=(Student)oin.readObject();
			oin.close();
			fin.close();
			return stu;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	@ApiOperation(value = "根据用户名和密码获取用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/showUserByUserNameAndPassWord", method = RequestMethod.GET, produces = "application/json")
	public 		User toIndex(HttpServletRequest request,@ApiParam(name = "username", required = true, value = "用户名") @RequestParam("username") String  username,@ApiParam(name = "password", required = true, value = "密码") @RequestParam("password")String  password) throws Exception{
		log.error("用户名："+username+"；密码："+password);
		// （1）使用用户的登录信息创建令牌.token可以理解为用户令牌，登录的过程被抽象为Shiro验证令牌是否具有合法身份以及相关权限。
		log.error("（1）使用用户的登录信息创建令牌.token可以理解为用户令牌，登录的过程被抽象为Shiro验证令牌是否具有合法身份以及相关权限。");
		log.error("(2) 获取SecurityManager对象");
		SecurityManager securityManager = (SecurityManager) ShiroApiUtil.getShiroSecurityManagerExistIniFile(ShiroInUseCons.APP_REAMLE_INI);
		//（2）执行登陆动作
		log.error("(3)执行登陆动作");
		log.error(" (3。1)注入SecurityManager.得到SecurityManager实例 并绑定给SecurityUtils  ");
		SecurityUtils.setSecurityManager(securityManager); // 注入SecurityManager
		log.error(" (3。2)获取Subject单例对象");

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
			token.setRememberMe(true);
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

		return  new User(username, password, 12);
	}

}
