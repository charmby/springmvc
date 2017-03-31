package com.gsafety.exceptionHandlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.gsafety.UnknownResourceException;
import com.gsafety.exceptions.common.GsafetyException;

public class SimpleExceptionHandler implements HandlerExceptionResolver {   
	  
    @Override  
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {   
        //添加自己的异常处理逻辑，如日志记录等        
    	ModelAndView module = 	new ModelAndView();
    	if(ex instanceof GsafetyException) {
    		module.addObject("status", "444");
    		module.addObject("exceptionMessage", ex.getMessage());
    		
    		}
    	module.addObject(ex);
    	response.setContentType("application/json;charset=utf-8;");
    	module.setViewName("exception");
        return module;   
    }   
  
}