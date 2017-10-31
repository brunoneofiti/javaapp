package br.com.brunoneofiti.app.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.city.business.CityBusiness;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;

@RestController
public class CityController {

	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private CityBusiness business;

	
	/**
	 * 
	 * @param cityname
	 * @return first city of the database
	 */
    @RequestMapping("/ws/getCity")
    public String getCity(@RequestParam(value="cityname", defaultValue="Utrecht") String cityname) {
        
    	//get information from the "database"
    	for(Address a : addressDAO.getAddressesOfOneCity(cityname)) {
    		if(a.getCity() != null) return a.getCity(); 
    	}
    	
    	//if not find return null
    	return null;
    }
    
    /**
     * 
     * @return List of all cities in the database
     * @throws BusinessException 
     */
    @RequestMapping("/ws/getCityList")
    public @ResponseBody List<City> getCityList() throws BusinessException {
 
    	return business.getAllCities();
    }

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
	
}
