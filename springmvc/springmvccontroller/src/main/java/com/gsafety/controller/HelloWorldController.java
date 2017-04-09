package com.gsafety.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

1、springfox首先扫描@RestController货@Controller注解，有这个注解的才是springmvc的类，才能扫描到springfox的ui中。
2. 然后springfox 扫描requestmapping中的value值，该值是请求url。
 
  在
 * @author xiaodonghong
 *
 */
@RequestMapping(value = "/hello/api")
@RestController(value="/hello")
@Api(value = "欢迎页面API", description = "有关于欢迎页面的操作", position = 1)  
@ApiResponses( value = { 
		@ApiResponse(code = 100, message = "(继续)请求者应当继续提出请求。服务器返回此代码表示已收到请求的第一部分，正在等待其余部分"),  
		@ApiResponse(code = 101, message = "(切换协议)请求者已要求服务器切换协议，服务器已确认并准备切换。  "),  
		@ApiResponse(code = 200, message = "服务器已成功处理了请求"),  
		@ApiResponse(code = 205, message = "（重置内容） 服务器成功处理了请求，但没有返回任何内容"),  
		@ApiResponse(code = 301, message = "（永久移动）  请求的网页已永久移动到新位置。 服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。"),  
		@ApiResponse(code = 304, message = "（未修改） 自从上次请求后，请求的网页未修改过。 服务器返回此响应时，不会返回网页内容。"),  
		@ApiResponse(code = 307, message = "（临时重定向）  服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求"),  
		@ApiResponse(code = 400, message = "（错误请求） 服务器不理解请求的语法"),  
		@ApiResponse(code = 401, message = "（未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。"),  
		@ApiResponse(code = 403, message = "（禁止） 服务器拒绝请求"),  
		@ApiResponse(code = 404, message = "（未找到） 服务器找不到请求的网页"),  
		@ApiResponse(code = 408, message = "（请求超时）  服务器等候请求时发生超时"),  
		@ApiResponse(code = 414, message = "（请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理"),  
		@ApiResponse(code = 500, message = "（服务器内部错误）  服务器遇到错误，无法完成请求")} 
		)  
public class HelloWorldController implements Controller {
	
	static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
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
		logger.info(name2);
		ModelAndView mv = new ModelAndView();
		//添加模型数据，可以是任意的po对象。
		mv.addObject("message", "hello world!");
		mv.addObject("date", "日期数据！");
		mv.setViewName("hello");
		logger.info("进入hello.js页面的方法。");
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
	public JSONResult test(@RequestBody BlogArticle blogArticleBeen,
			@PathVariable Long path,
			String query,
			@RequestHeader String apiKey,
			PageInfo pageInfoBeen){
		logger.info("进入hello.js页面的方法。");
		logger.info("blogArticleBeen.getLastUpdateTime():"+blogArticleBeen.getLastUpdateTime());
		logger.info("blogArticleBeen.getSorter():"+blogArticleBeen.getSorter());
		logger.info("path:"+path);
		logger.info("query:"+query);
		logger.info("apiKey:"+apiKey);
		logger.info("pageInfoBeen.getNowPage():"+pageInfoBeen.getNowPage());
		logger.info("pageInfoBeen.getPageSize():"+pageInfoBeen.getPageSize());
		JSONResult jsonResult = new JSONResult();
		jsonResult.setMessage("success");
		jsonResult.setMessageCode(null);
		jsonResult.setCode(0);
		jsonResult.setBody(null);
		logger.info(jsonResult.toString());
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
		logger.info("进入查询用户方法！");
		User user = new User(userId, "haoyifen", 24);
		Result result = new Result();
		result.setCode(0);
		result.setData(user);
		result.setMessage("success");
		logger.info(result.toString());
		return result;
	}
}
