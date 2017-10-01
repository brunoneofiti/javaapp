package com.backbase.assignment.dutchCities.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.assignment.dutchCities.dao.CityDAO;
import com.backbase.assignment.dutchCities.model.City;
import com.backbase.assignment.mainPage.dao.AddressDAO;
import com.backbase.assignment.mainPage.model.Address;
import com.backbase.assignment.mainPage.model.Geolocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DutchCityController {

    @RequestMapping("/ws/createAtm")
    public @ResponseBody List<Address> addAtm(@RequestParam(value="json") String json) {
        
    	AddressDAO dao = new AddressDAO();

    	List<Address> addressList = new ArrayList<Address>();
    	
		ObjectMapper mapper = new ObjectMapper();

		City city;
    	
		try {
			
			city = mapper.readValue(json, City.class);
			
			//get from "database"
			addressList = dao.getAddressesFromDatabase();
			
			//add to list 
			addressList.add(new Address("Avenue Main", 10, "00545", city, new Geolocation("12", "33"), 12, "ING"));
	    	
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return addressList;
    }

	
    @RequestMapping("/ws/getAtmList")
    public List<Address> getAtmAdress(@RequestParam(value="cityname", defaultValue="Utrecht") String cityname) {
        
    	//get information from the "database"
    	AddressDAO dao = new AddressDAO();
    	
    	//return select city from "database"
    	//if the user choose amsterdam return none
    	return dao.getAddressesOfOneCity(cityname);
    }

    @RequestMapping("/ws/getCity")
    public City getCity(@RequestParam(value="cityname", defaultValue="Utrecht") String cityname) {
        
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
    public @ResponseBody List<City> cities() {
        
    	//get information from the "database"
    	CityDAO dao = new CityDAO(); 
    	
    	//return all cities
    	return dao.getCities();
    }
}