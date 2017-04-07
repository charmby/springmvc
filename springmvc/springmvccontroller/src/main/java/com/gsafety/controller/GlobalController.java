package com.gsafety.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import com.gsafety.po.FormatModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "/global")
@Api(value = "国际化示例API", description = "有关于国际化示例的操作", position = 1)  
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
public class GlobalController {

	@RequestMapping(value="/test", method = {RequestMethod.GET})
	/*    @ResponseBody*/

	/**
	 * 只有注销 @ResponseBody，请求才能进入到请求页面中。
	 * @param request
	 * @param model
	 * @return
	 */
	public ModelAndView test(HttpServletRequest request,Model model){
		if(!model.containsAttribute("contentModel")){

			//从后台代码获取国际化信息
			RequestContext requestContext = new RequestContext(request);
			model.addAttribute("money", requestContext.getMessage("money"));
			model.addAttribute("date", requestContext.getMessage("date"));

			FormatModel formatModel=new FormatModel();
			formatModel.setMoney(12345.678);
			formatModel.setDate(new Date());
			model.addAttribute("contentModel", formatModel);
		}
		ModelAndView mv = new ModelAndView();
		//添加模型数据，可以是任意的po对象。
		mv.addObject("money", "1234.56");
		mv.addObject("date", new Date());
		mv.setViewName("globaltest");
		return mv;
	}
	/*    只有注销 @ResponseBody，请求才能进入到请求页面中。*/
	@RequestMapping(value="/test2", method = {RequestMethod.GET})
	public String test2(HttpServletRequest request,Model model,@RequestParam(value="langType", defaultValue="zh" ) String langType){
		if(!model.containsAttribute("contentModel")){

			if(langType.equals("zh")){
				Locale locale = new Locale("zh", "CN"); 
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
			}
			else if(langType.equals("en")){
				Locale locale = new Locale("en", "US"); 
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
			}
			else{ 
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
			}
			//从后台代码获取国际化信息
			RequestContext requestContext = new RequestContext(request);
			model.addAttribute("money", requestContext.getMessage("money"));
			model.addAttribute("date", requestContext.getMessage("date"));


			FormatModel formatModel=new FormatModel();

			formatModel.setMoney(12345.678);
			formatModel.setDate(new Date());

			model.addAttribute("contentModel", formatModel);
		}
		return "globaltest2";
	}
	
	/**
	 * <bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver" />
注释掉，并添加以下内容：

<bean id="localeResolver" class="org.springframework.web.servlet.i18n.CookieLocaleResolver" />
	 * @param request
	 * @param model
	 * @param langType
	 * @return
	 */
	 @RequestMapping(value="/test3", method = {RequestMethod.GET})
	    public String test3(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value="langType", defaultValue="zh") String langType){
	        if(!model.containsAttribute("contentModel")){
	            
	            if(langType.equals("zh")){
	                Locale locale = new Locale("zh", "CN"); 
	                //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
	                (new CookieLocaleResolver()).setLocale (request, response, locale);
	            }
	            else if(langType.equals("en")){
	                Locale locale = new Locale("en", "US"); 
	                //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
	                (new CookieLocaleResolver()).setLocale (request, response, locale);
	            }
	            else 
	                //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
	                (new CookieLocaleResolver()).setLocale (request, response, LocaleContextHolder.getLocale());
	            
	            //从后台代码获取国际化信息
	            RequestContext requestContext = new RequestContext(request);
	            model.addAttribute("money", requestContext.getMessage("money"));
	            model.addAttribute("date", requestContext.getMessage("date"));

	            
	            FormatModel formatModel=new FormatModel();

	            formatModel.setMoney(12345.678);
	            formatModel.setDate(new Date());
	            
	            model.addAttribute("contentModel", formatModel);
	        }
	        return "globaltest3";
	    }


}