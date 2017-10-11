package br.com.brunoneofiti.app.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlingController  {

	private Log log = LogFactory.getLog(ExceptionHandlingController.class);

	// @RequestHandler methods
	//...
	
//	// Exception handling methods
//	// Convert a predefined exception to an HTTP Status code
//	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public void conflict() {
//		// Nothing to do
//	}

	// Total control - setup a model and return the view name yourself. Or
	// consider subclassing ExceptionHandlerExceptionResolver (see below).
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest request, Exception e) {
		
		log.error("Request: " + request.getRequestURL() + " raised " + e);
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("title", "Error");
		model.addObject("content", e);
		model.addObject("url", request.getRequestURL());
		
		model.setViewName("error");
		
		return model;
	  }

}
