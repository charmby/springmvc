package com.gsafety.exceptionHandlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

public class RestExceptionHandler extends AbstractHandlerExceptionResolver{

	@Override
	protected ModelAndView doResolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		return null;
	}

}
