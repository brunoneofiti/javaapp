package br.com.brunoneofiti.app.city.controller;

import java.util.List;

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

    @RequestMapping("/ws/getCity")
    public String getCity(@RequestParam(value="cityname", defaultValue="Utrecht") String cityname) {
        
    	//get information from the "database"
    	AddressDAO dao = new AddressDAO();
    	
    	List<Address> addressList =  dao.getAddressesOfOneCity(cityname);
    	
    	for(Address a : addressList) {
    		if(a.getCity() != null) {
        		return a.getCity();
    		}
    	}
    	
    	//if not find return null
    	return null;
    }

    @RequestMapping("/ws/getCityList")
    public @ResponseBody List<City> getCityList() {
 
    	//get information from the "database"
    	CityDAO dao = new CityDAO(); 
    	
    	//return all cities
    	return dao.getCities();
    }

	
}
