package com.gsafety.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gsafety.po.BlogArticle;
import com.gsafety.po.JSONResult;
import com.gsafety.po.PageInfo;
import com.gsafety.po.Result;
import com.gsafety.po.User;

/**
 * 开发处理器/页面控制器
 * 
 * org.springframework.web.servlet.mvc.Controller：页面控制器/处理器必须实现 Controller 接口，注意别
选错了；后边我们会学习其他的处理器实现方式；
public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) ：功能处
理方法，实现相应的功能处理，比如收集参数、验证参数、绑定参数到命令对象、将命令对象传入业务对象进行业务处理、
最后返回 ModelAndView 对象；
ModelAndView：包含了视图要实现的模型数据和逻辑视图名；“mv.addObject("message", "Hello World!");
”表示添加模型数据，此处可以是任意 POJO 对象；“mv.setViewName("hello");”表示设置逻辑视图名为“hello”，
视图解析器会将其解析为具体的视图，如前边的视图解析器 InternalResourceVi。wResolver 会将其解析为
“WEB-INF/jsp/hello.jsp
 * @author Thinkpad
 *
 */
@Api(value = "contacts-api", description = "有关于用户的CURD操作", position = 5)  
@RequestMapping(value = "/v1/api")
@RestController(value="/hello")
public class HelloWorldController implements Controller {
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.收集参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		String name2 = this.getName();
		System.out.println(name2);
		String  age2 = this.getAge();
		System.out.println(age2);
		ModelAndView mv = new ModelAndView();
		//添加模型数据，可以是任意的po对象。
		mv.addObject("message", "hello world!");
		mv.addObject("date", "日期数据！");
		mv.setViewName("hello");
		return mv;
	}
	//这里使用POST @RequestBody必须使用POST才能接收，这里方便讲解
	@ApiOperation(value = "一个测试API", notes = "第一个测试API")
	@ResponseBody
	@RequestMapping(value = "/test/{path}", method = RequestMethod.POST)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "blogArticleBeen", value = "文档对象", required = true, paramType = "body", dataType = "BlogArticleBeen"),
		@ApiImplicitParam(name = "path", value = "url上的数据", required = true, paramType = "path", dataType = "Long"),
		@ApiImplicitParam(name = "query", value = "query类型参数", required = true, paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "apiKey", value = "header中的数据", required = true, paramType = "header", dataType = "String")
	})
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "更新成功"),  
			@ApiResponse(code = 404, message = "找不到页面"),  
			@ApiResponse(code = 500, message = "内部报错")}  
			)  
	public JSONResult test(@RequestBody BlogArticle blogArticleBeen,
			@PathVariable Long path,
			String query,
			@RequestHeader String apiKey,
			PageInfo pageInfoBeen){
		System.out.println("blogArticleBeen.getLastUpdateTime():"+blogArticleBeen.getLastUpdateTime());
		System.out.println("blogArticleBeen.getSorter():"+blogArticleBeen.getSorter());
		System.out.println("path:"+path);
		System.out.println("query:"+query);
		System.out.println("apiKey:"+apiKey);
		System.out.println("pageInfoBeen.getNowPage():"+pageInfoBeen.getNowPage());
		System.out.println("pageInfoBeen.getPageSize():"+pageInfoBeen.getPageSize());
		JSONResult jsonResult = new JSONResult();
		jsonResult.setMessage("success");
		jsonResult.setMessageCode(null);
		jsonResult.setCode(0);
		jsonResult.setBody(null);
		return jsonResult;
	}
	@RequestMapping(value="/testmapping")
	public void testRequestMapping(){
		System.out.println("dsfdsfdsa");
	}

	@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "queryUserById", method = RequestMethod.GET, produces = "application/json")
	public Result queryUserById(@ApiParam(name = "userId", required = true, value = "用户Id") @RequestParam("userId") int userId, HttpServletRequest request) {
		User user = new User(userId, "haoyifen", 24);
		Result result = new Result();
		result.setCode(0);
		result.setData(user);
		result.setMessage("success");
		return result;
	}
}
