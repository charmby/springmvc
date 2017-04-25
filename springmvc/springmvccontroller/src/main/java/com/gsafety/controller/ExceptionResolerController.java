package com.gsafety.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.gsafety.exceptions.common.GsafetyException;
import com.gsafety.po.Result;
import com.gsafety.po.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 
 * 异常处理信息 
 * @author xiaodh
 * 2017年3月27日 上午11:03:48
 */
@Api(value = "异常处理页面API", description = "有关于异常处理的操作", position = 2)  
@RequestMapping(value = "/exception")
@RestController(value="/excep")
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
public class ExceptionResolerController implements Controller {
	private static Logger logger  = LoggerFactory.getLogger(ExceptionResolerController.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.收集参数
		// 2、绑定参数到命令对象
		// 3、将命令对象传入业务对象进行业务处理
		// 4、选择下一个页面
		logger.info("调用了测试页面，返回hello.jsp页面！");
		ModelAndView mv = new ModelAndView();
		//添加模型数据，可以是任意的po对象。
		mv.addObject("message", "hello world!");
		mv.addObject("date", "日期数据！");
		mv.setViewName("hello");
		return mv;
	}

	@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "queryUserById", method = RequestMethod.GET, produces = "application/json")
	public Result queryUserById(@ApiParam(name = "userId", required = true, value = "用户Id") @RequestParam("userId") int userId, HttpServletRequest request) throws GsafetyException {
		logger.info("查询用户，并抛出异常，用于测试异常信息！");
		User user = new User(userId, "haoyifen", "111");
		Result result = new Result();
		result.setCode(0);
		result.setData(user);
		result.setMessage("success");
		throw new GsafetyException("100012", "未找到用户");
	}
	
	@ExceptionHandler
	@ApiOperation(value = "根据 @ExceptionHandler信息", httpMethod = "GET", produces = "application/json")
	@ApiResponse(code = 200, message = "success", response = Result.class)
	@ResponseBody
	@RequestMapping(value = "queryUserByIdExceptionHandler", method = RequestMethod.GET, produces = "application/json")
	public String queryUserByIdExceptionHandler(@ApiParam(name = "userId", required = true, value = "用户Id") @RequestParam("userId") int userId, HttpServletRequest request) throws GsafetyException {
		logger.info("查询用户，并抛出异常，返回exception.jsp页面！");
		User user = new User(userId, "haoyifen", "111");
		Result result = new Result();
		result.setCode(0);
		result.setData(user);
		result.setMessage("success");
		 
		 //添加自己的异常处理逻辑，如日志记录　　　
        request.setAttribute("exceptionMessage", new GsafetyException("100012", "未找到用户").getMessage());  
    	logger.info("给request重新定义内容！");
        return "exception";
	}
}
