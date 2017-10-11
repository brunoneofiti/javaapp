package br.com.brunoneofiti.app.atm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brunoneofiti.app.atm.business.ATMBusiness;
import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.atm.model.Geolocation;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;

@RestController
public class ATMController {
	
	private Log log = LogFactory.getLog(ATMController.class);

	
	/**
	 * Public WS.
	 * List ATM by cityname
	 * @param cityname
	 * @return
	 * @throws BusinessException 
	 */
    @RequestMapping("/ws/getAtmList")
    public List<ATM> getAtmList(@RequestParam(value="cityname", defaultValue="Utrecht") String cityname) throws BusinessException {
        
    	//get information from the "database"
    	AtmDAO dao = new AtmDAO();
    	
		ATMBusiness business = new ATMBusiness();
		business.checkAtms(dao);
    	
    	return dao.getAtmFromDatabase();
    }

	/**
	 * Public WS
	 * Create ATM passing JSON
	 * @param json
	 * @return
	 * @throws BusinessException 
	 */
    @RequestMapping("/ws/createAtm")
    public @ResponseBody List<Address> createAtm(@RequestParam(value="json") String json) throws BusinessException {
        
    	AddressDAO dao = new AddressDAO();

		ATMBusiness business = new ATMBusiness();
		business.checkAddress(dao);
    	
    	List<Address> addressList = new ArrayList<Address>();
    	
		ObjectMapper mapper = new ObjectMapper();

		City city;
    	
		try {
			
			city = mapper.readValue(json, City.class);
			
			//get from "database"
			addressList = dao.getAddressesFromDatabase();
			
			//add to list 
			addressList.add(new Address("Avenue Main", "10", "00545", city.getName(), new Geolocation("12", "33")));
	    	
		} catch (JsonParseException e) {
			log.error("JsonParseException problem");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			log.error("JsonMappingException problem");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException problem");
			e.printStackTrace();
		}
    	
    	return addressList;
    }

	
	/**
	 * Restricted WS
	 * List of All ING ATMs
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value = "/restricted/selectAtmByCity", method = RequestMethod.GET)
	public ModelAndView selectAtmByCity() throws BusinessException {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "JavaApp Title");
		model.addObject("subtitle", "List of ING ATMs by city");
		model.addObject("content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc odio justo, viverra eget laoreet ut, ultrices eget eros. Nunc in scelerisque nisl. Donec nisl ipsum, hendrerit at orci non, vehicula convallis neque. Nulla in lorem posuere, mollis est at, consectetur eros. Duis scelerisque justo vitae erat ultrices, sed eleifend velit malesuada. Nunc rhoncus nulla vel sapien luctus, a pulvinar dui vestibulum. Curabitur tortor turpis, dapibus eget ultricies quis, varius nec justo. Vestibulum dui turpis, viverra in dapibus eget, condimentum faucibus velit. Mauris hendrerit est vitae augue feugiat euismod. Ut pulvinar enim ipsum, ut ullamcorper massa venenatis congue. Nam libero tellus, pellentesque ac augue quis, suscipit auctor velit. Donec finibus, arcu at pulvinar imperdiet, nisl diam imperdiet eros, sed convallis nulla neque sit amet augue.");
		
		CityDAO dao = new CityDAO();
		
		ATMBusiness business = new ATMBusiness();
		business.checkCities(dao);
		
		model.addObject("city", dao.getCity().getName());
		model.addObject("cities", dao.getCities());
		
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

		ModelAndView model = new ModelAndView();
		model.addObject("title", "JavaApp Title");
		model.addObject("subtitle", "Add city to list of ING ATMs ");
		model.addObject("content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc odio justo, viverra eget laoreet ut, ultrices eget eros. Nunc in scelerisque nisl. Donec nisl ipsum, hendrerit at orci non, vehicula convallis neque. Nulla in lorem posuere, mollis est at, consectetur eros. Duis scelerisque justo vitae erat ultrices, sed eleifend velit malesuada. Nunc rhoncus nulla vel sapien luctus, a pulvinar dui vestibulum. Curabitur tortor turpis, dapibus eget ultricies quis, varius nec justo. Vestibulum dui turpis, viverra in dapibus eget, condimentum faucibus velit. Mauris hendrerit est vitae augue feugiat euismod. Ut pulvinar enim ipsum, ut ullamcorper massa venenatis congue. Nam libero tellus, pellentesque ac augue quis, suscipit auctor velit. Donec finibus, arcu at pulvinar imperdiet, nisl diam imperdiet eros, sed convallis nulla neque sit amet augue.");
		
		CityDAO dao = new CityDAO();
		
		ATMBusiness business = new ATMBusiness();
		business.checkCities(dao);
		
		model.addObject("city", dao.getCity().getName());
		model.addObject("cities", dao.getCities());
		
		model.setViewName("createAtm");
		return model;
	}
	
}
