package br.com.brunoneofiti.app.mainPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	private ModelAndView model;

	
	/**
	 * Home or Main Page of the application 
	 * Restricted Access (password only)
	 * @return
	 */
	@RequestMapping(value = "/restricted**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		model = new ModelAndView();
		
		model.addObject("title", "JavaApp Title");
		model.addObject("content", "See list.");
		model.setViewName("main");

		return model;
	}
}