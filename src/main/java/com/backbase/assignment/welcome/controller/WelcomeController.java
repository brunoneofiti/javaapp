package com.backbase.assignment.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		
		
		ModelAndView model = new ModelAndView();
		model.addObject("title", "JavaApp Title");
		model.addObject("content", "Welcome to JavaApp!");
		model.setViewName("index");
		
		return model;
	}

}