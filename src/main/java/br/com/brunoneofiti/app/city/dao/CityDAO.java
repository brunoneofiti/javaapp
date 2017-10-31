package br.com.brunoneofiti.app.city.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Repository 
public class CityDAO {
	
	private Log log = LogFactory.getLog(CityDAO.class);
	
	private	AtmDAO atmDAO;
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	private City createDutchCity(String name){
		
		City city = null;
		
		switch (name) {
			case "Utrecht" : city = new City(name, "Utrecht", "Netherlands");
				break;   
			case "Eindhoven" : city = new City(name, "Hertogenbosch", "Netherlands");
				break;
			case "Rotterdam" : city = new City(name, "The Hague", "Netherlands");
				break;
			case "Amsterdam" : city = new City(name, "Haarlem", "Netherlands");
				break;
			case "Maastricht" : city = new City(name, "Maastricht", "Netherlands");
				break;
			default: city = new City(name, "Province", "Netherlands");
		}
		
		return city;
	}
	
	
	public City getCity() {
		return getCity("");
	}

	
	/**
	 * Return just first city of the database
	 * @return
	 */
	public City getCity(String name) {
		
		List<City> cityList = new ArrayList<City>();
		
		cityList = getCitiesFromDatabase();
		
		if(name.equals("") || name == null) return cityList.get(0);
		
		City myCity = createDutchCity(name);
		
		for(City c : cityList){
			if(c.equals(myCity)) return myCity;
		}
		
		return cityList.get(0);
	}
	
	
	/**
	 * 
	 * @return
	 */
    public List<City> getCitiesFromDatabase() {
    	
    	Set<City> citySet = new HashSet<City>();
    	
		try {
	    	
			atmDAO = new AtmDAO();
			
			List<ATM> atmList = atmDAO.getAtmFromDatabase();
			
	    	for(ATM atm : atmList){
	    		citySet.add(createDutchCity(atm.getAddress().getCity()));
	    	}
	    	
		} catch (BusinessException e) {
			
			log.error("problem calling data from database (json file in fact) ");
			
			e.printStackTrace();
		}
    	
    	return new ArrayList<City>(citySet);
	}

}