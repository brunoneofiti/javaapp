package br.com.brunoneofiti.app.geolocation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.brunoneofiti.app.common.business.BusinessException;
import br.com.brunoneofiti.app.geolocation.business.MapBusiness;

@Controller
public class MapController {
	
	@Autowired
	private MapBusiness business;

	private ModelAndView model;

	
	/**
	 * Restricted WS
	 * List of All ING ATMs
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public ModelAndView getMap() throws BusinessException {
		
		model = new ModelAndView();
		
		model.addObject("title", "JavaApp Title");
		model.addObject("lat", business.getOneATM().getAddress().getGeoLocation().getLat());
		model.addObject("lng", business.getOneATM().getAddress().getGeoLocation().getLng());
		
		model.setViewName("map");
		
		return model;
	}

	
}
