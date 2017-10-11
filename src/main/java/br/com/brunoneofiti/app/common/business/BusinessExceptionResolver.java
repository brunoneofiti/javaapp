package br.com.brunoneofiti.app.common.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class BusinessExceptionResolver extends SimpleMappingExceptionResolver  {
 
	  @Override
	  public String buildLogMessage(Exception e, HttpServletRequest request) {
	    return "MVC exception: " + e.getLocalizedMessage();
	  }
	    
	  @Override
	  protected ModelAndView doResolveException(HttpServletRequest request,
	        HttpServletResponse response, Object handler, Exception e) {
		  
	    // Call super method to get the ModelAndView
	    ModelAndView model = super.doResolveException(request, response, handler, e);
	        
	    // Make the full URL available to the view - note ModelAndView uses
	    // addObject() but Model uses addAttribute(). They work the same. 
	    model.addObject("url", request.getRequestURL());
	    
	    return model;
	  }
}