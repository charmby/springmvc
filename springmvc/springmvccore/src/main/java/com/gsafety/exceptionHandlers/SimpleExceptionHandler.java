package com.gsafety.exceptionHandlers;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


import com.gsafety.UnknownResourceException;

public class SimpleExceptionHandler implements HandlerExceptionResolver {   
	  
    @Override  
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {   
        //添加自己的异常处理逻辑，如日志记录等        
    	ModelAndView module = 	new ModelAndView();
    	if(ex instanceof UnknownResourceException) {
    		module.addObject("status", "444");
    		module.addObject("message", ex.getMessage());
    		
    		}
    	response.setContentType("application/json;charset=utf-8;");
        return module;   
    }   
  
}