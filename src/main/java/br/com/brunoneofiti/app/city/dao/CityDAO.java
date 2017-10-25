package br.com.brunoneofiti.app.city.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Repository 
public class CityDAO {
	
	private	AtmDAO atmDAO;
	
	
	/**
	 * Return just first city of the database
	 * @return
	 */
	public City getCity() {

		List<City> cityList = new ArrayList<City>();
		
		cityList = getCitiesFromDatabase();
		
		return cityList.get(0);
	}
	
	
	/**
	 * 
	 * @return
	 */
    public List<City> getCitiesFromDatabase() {
    	
    	List<City> cityList = new ArrayList<City>();
    	
		try {
	    	
			atmDAO = new AtmDAO();
			
			List<ATM> atmList = atmDAO.getAtmFromDatabase();
			
	    	for(ATM atm : atmList){
	    		
				switch (atm.getAddress().getCity()) {  
				
					case "Utrecht" : cityList.add(new City(atm.getAddress().getCity(), "Utrecht", "Netherlands"));  
					break;   
					
					case "Eindhoven" : cityList.add(new City(atm.getAddress().getCity(), "Hertogenbosch", "Netherlands"));  
					break;
					
					case "Rotterdam" : cityList.add(new City(atm.getAddress().getCity(), "The Hague", "Netherlands"));  
					break;
					
					case "Amsterdam" : cityList.add(new City(atm.getAddress().getCity(), "Haarlem", "Netherlands"));  
					break;
					
					case "Maastricht" : cityList.add(new City(atm.getAddress().getCity(), "Maastricht", "Netherlands"));  
					break;
					
					default: cityList.add(new City(atm.getAddress().getCity(), "Province", "Netherlands"));
				}
	    	}
	    	
		} catch (BusinessException e) {
			e.printStackTrace();
		}
    	
    	return cityList;
	}
    
    
    /**
     * 
     * @return
    private List<City> addToCityList(){
    	
    	cityList = new ArrayList<City>();
		
    	cityList.add(new City("Utrecht", "Utrecht", "Netherlands"));
    	cityList.add(new City("Eindhoven","Hertogenbosch",  "Netherlands"));
    	cityList.add(new City("Rotterdam","The Hague",  "Netherlands"));
    	cityList.add(new City("Amsterdam", "Haarlem", "Netherlands"));
    	cityList.add(new City("Maastricht", "Maastricht", "Netherlands"));

    	return this.cityList;
    }
     */
}