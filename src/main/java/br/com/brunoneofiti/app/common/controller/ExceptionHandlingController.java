package br.com.brunoneofiti.app.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import br.com.brunoneofiti.app.common.business.BusinessException;

@ControllerAdvice
public class ExceptionHandlingController  {

	private Log log = LogFactory.getLog(ExceptionHandlingController.class);

	// Total control - setup a model and return the view name yourself. Or
	// consider subclassing ExceptionHandlerExceptionResolver (see below).
	@ExceptionHandler(Exception.class)
	public ModelAndView handleErrorException(HttpServletRequest request, Exception e) {
		
		log.error("Request: " + request.getRequestURL() + " raised " + e);
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("title", "Error");
		model.addObject("content", e);
		model.addObject("url", request.getRequestURL());
		
		model.setViewName("error");
		
		return model;
	  }

	@ExceptionHandler(BusinessException.class)
	public ModelAndView handleErrorBusinessException(HttpServletRequest request, Exception e) {
		
		log.error("Request: " + request.getRequestURL() + " raised " + e);
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("title", "Business Error");
		model.addObject("content", e);
		model.addObject("url", request.getRequestURL());
		
		model.setViewName("error");
		
		return model;
	  }

	
}
