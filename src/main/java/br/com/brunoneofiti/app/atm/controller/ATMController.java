package br.com.brunoneofiti.app.atm.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.brunoneofiti.app.atm.business.ATMBusiness;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.common.business.BusinessException;

@RestController
public class ATMController {
	
	private Log log = LogFactory.getLog(ATMController.class);
	
	@Autowired
	private ATMBusiness business;

	private ModelAndView model;

	/**
	 * Public WS.
	 * List ATM by cityname
	 * @param cityname
	 * @return
	 * @throws BusinessException 
	 */
    @RequestMapping("/ws/getDutchCityList")
    public List<String> getDutchCityList(@RequestParam(value="cityname", defaultValue="all") String cityname) 
    		throws BusinessException {
        
		return business.getCityByATMList(cityname);
    }

	/**
	 * Public WS.
	 * List ATM by cityname
	 * @param cityname
	 * @return
	 * @throws BusinessException 
	 */
    @RequestMapping("/ws/getAtmList")
    public List<ATM> getAtmList() 
    		throws BusinessException {
        
		return business.getAllATMs();
    }
    
	/**
	 * Public WS
	 * Create ATM passing JSON
	 * @param json
	 * @return
	 * @throws BusinessException 
	 */
    @RequestMapping("/ws/createAtm")
    public @ResponseBody List<ATM> createAtm(@RequestParam(value="json") String json) throws BusinessException {
        
		return business.createCityValidate(json);
    }

	
	/**
	 * Restricted WS
	 * List of All ING ATMs
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value = "/restricted/selectAtmByCity", method = RequestMethod.GET)
	public ModelAndView selectAtmByCity() throws BusinessException {
		
		model = new ModelAndView();
		
		model.addObject("title", "JavaApp Title");
		model.addObject("subtitle", "List of ING ATMs by city");
		model.addObject("content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc odio justo, viverra eget laoreet ut, ultrices eget eros. Nunc in scelerisque nisl. Donec nisl ipsum, hendrerit at orci non, vehicula convallis neque. Nulla in lorem posuere, mollis est at, consectetur eros. Duis scelerisque justo vitae erat ultrices, sed eleifend velit malesuada. Nunc rhoncus nulla vel sapien luctus, a pulvinar dui vestibulum. Curabitur tortor turpis, dapibus eget ultricies quis, varius nec justo. Vestibulum dui turpis, viverra in dapibus eget, condimentum faucibus velit. Mauris hendrerit est vitae augue feugiat euismod. Ut pulvinar enim ipsum, ut ullamcorper massa venenatis congue. Nam libero tellus, pellentesque ac augue quis, suscipit auctor velit. Donec finibus, arcu at pulvinar imperdiet, nisl diam imperdiet eros, sed convallis nulla neque sit amet augue.");
		
		CityDAO dao = new CityDAO();
		
		business.checkCities(dao);
		
		model.addObject("city", dao.getCity().getName());
		model.addObject("cities", dao.getCitiesFromDatabase());
		
		model.setViewName("selectAtmByCity");
		return model;
	}

	/**
	 * Restriceted WS. 
	 * Add ATM to list of ING ATMs
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value = "/restricted/createAtm", method = RequestMethod.GET)
	public ModelAndView createAtm() throws BusinessException {

		model = new ModelAndView();
		
		model.addObject("title", "JavaApp Title");
		model.addObject("subtitle", "Add city to list of ING ATMs ");
		model.addObject("content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc odio justo, viverra eget laoreet ut, ultrices eget eros. Nunc in scelerisque nisl. Donec nisl ipsum, hendrerit at orci non, vehicula convallis neque. Nulla in lorem posuere, mollis est at, consectetur eros. Duis scelerisque justo vitae erat ultrices, sed eleifend velit malesuada. Nunc rhoncus nulla vel sapien luctus, a pulvinar dui vestibulum. Curabitur tortor turpis, dapibus eget ultricies quis, varius nec justo. Vestibulum dui turpis, viverra in dapibus eget, condimentum faucibus velit. Mauris hendrerit est vitae augue feugiat euismod. Ut pulvinar enim ipsum, ut ullamcorper massa venenatis congue. Nam libero tellus, pellentesque ac augue quis, suscipit auctor velit. Donec finibus, arcu at pulvinar imperdiet, nisl diam imperdiet eros, sed convallis nulla neque sit amet augue.");
		
		CityDAO dao = new CityDAO();
		
		business.checkCities(dao);
		
		model.addObject("city", dao.getCity().getName());
		model.addObject("cities", dao.getCitiesFromDatabase());
		
		model.setViewName("createAtm");
		return model;
	}
	
}
