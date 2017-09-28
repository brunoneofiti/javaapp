package com.backbase.assignment.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestrictedController {


	/**
	 * Restricted area
	 * @return
	 */
	@RequestMapping(value = "/restricted**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "JavaApp Title");
		model.addObject("message", "This is protected page!");
		model.setViewName("main");

		return model;
	}


	/**
	 * list of ING ATMs
	 * @return
	 */
	@RequestMapping(value = "/restricted/ingAtms", method = RequestMethod.GET)
	public ModelAndView nonePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("city", "Amsterdan");
		model.addObject("message", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc odio justo, viverra eget laoreet ut, ultrices eget eros. Nunc in scelerisque nisl. Donec nisl ipsum, hendrerit at orci non, vehicula convallis neque. Nulla in lorem posuere, mollis est at, consectetur eros. Duis scelerisque justo vitae erat ultrices, sed eleifend velit malesuada. Nunc rhoncus nulla vel sapien luctus, a pulvinar dui vestibulum. Curabitur tortor turpis, dapibus eget ultricies quis, varius nec justo. Vestibulum dui turpis, viverra in dapibus eget, condimentum faucibus velit. Mauris hendrerit est vitae augue feugiat euismod. Ut pulvinar enim ipsum, ut ullamcorper massa venenatis congue. Nam libero tellus, pellentesque ac augue quis, suscipit auctor velit. Donec finibus, arcu at pulvinar imperdiet, nisl diam imperdiet eros, sed convallis nulla neque sit amet augue.");
		model.setViewName("ingAtms");
		return model;
	}

}