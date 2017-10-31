package br.com.brunoneofiti.app.login.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private Log log = LogFactory.getLog(LoginController.class);
	
	private ModelAndView model;
	
	/**
	 * Login Page. 
	 * Public Access
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		model = new ModelAndView();
		
		model.addObject("title", "Please, login with user and password");

		if (error != null) {
			if(log.isDebugEnabled()) log.debug("User fail to login");
			model.addObject("error", "Invalid username or password!");
		}
		

		if (logout != null) {
			if(log.isDebugEnabled()) log.debug("User logout sucessfull");
			model.addObject("content", "Bye!");
		}

		model.setViewName("login");

		return model;
	}
}