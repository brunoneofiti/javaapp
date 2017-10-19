package br.com.brunoneofiti.app.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.city.model.City;

@RestController
public class CityController {

	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private CityDAO cityDAO; 

	/**
	 * 
	 * @param cityname
	 * @return first city of the database
	 */
    @RequestMapping("/ws/getCity")
    public String getCity(@RequestParam(value="cityname", defaultValue="Utrecht") String cityname) {
        
    	//get information from the "database"
    	
    	List<Address> addressList =  addressDAO.getAddressesOfOneCity(cityname);
    	
    	for(Address a : addressList) {
    		if(a.getCity() != null) {
        		return a.getCity();
    		}
    	}
    	
    	//if not find return null
    	return null;
    }
    
    /**
     * 
     * @return List of all cities in the database
     */
    @RequestMapping("/ws/getCityList")
    public @ResponseBody List<City> getCityList() {
 
    	//return all cities
    	return cityDAO.getCitiesFromDatabase();
    }

	
}
