package com.gsafety.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gsafety.commonutil.MathUtils;
import com.gsafety.po.Result;
import com.gsafety.po.Student;
import com.gsafety.po.User;
import com.gsafety.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;



@RestController
@RequestMapping("/user")
@Api(value = "用户管理界面", description = "有关于用户管理的操作", position = 1)  
public class UserController{
	private static Logger log2 = 	Logger.getLogger(UserController.class);
	@Resource
	private IUserService userService;

	@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "/showUser", method = RequestMethod.GET, produces = "application/json")
	public 		User toIndex(HttpServletRequest request,@ApiParam(name = "id", required = true, value = "用户Id") @RequestParam("id") Integer id,Model model) throws Exception{
		log2.error(id+"的查询结z构！");
		/*
 //也可以通过request的方式获得id值
		int userId = Integer.parseInt(request.getParameter("id"));*/
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		log2.info("返回user对象："+user.toString());
		showClassLoader();
		getResource();
		getResourceLoad();
		demoForSerializable();
		ApplicationContext WebApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		MathUtils applicationname =(MathUtils) WebApplicationContext.getBean("mathUtils");
		applicationname.add(2, 2);
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
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void demoForSerializable(){
		// TODO 自动生成的方法存根
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;

	}



}
