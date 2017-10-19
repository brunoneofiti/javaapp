package br.com.brunoneofiti.app.city.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.brunoneofiti.app.city.model.City;

@Repository 
public class CityDAO {
	
	private List<City> cityList;
	
	/**
	 * Return just first city of the database
	 * @return
	 */
	public City getCity() {

		cityList = new ArrayList<City>();
		cityList = getCitiesFromDatabase();
		
		return this.cityList.get(0);
	}
	
	
	/**
	 * 
	 * @return
	 */
    public List<City> getCitiesFromDatabase() {
    	
    	cityList = new ArrayList<City>();
    	cityList = addToCityList();
    	
    	// just to add more data to the POC 
    	cityList.addAll(addToCityList());
    	cityList.addAll(addToCityList());
    	cityList.addAll(addToCityList());
    	cityList.addAll(addToCityList());
    	cityList.addAll(addToCityList());
    	
    	return this.cityList;
	}
    
    
    /**
     * 
     * @return
     */
    private List<City> addToCityList(){
    	
    	cityList = new ArrayList<City>();
		
    	cityList.add(new City("Utrecht", "Utrecht", "Netherlands"));
    	cityList.add(new City("Eindhoven","Hertogenbosch",  "Netherlands"));
    	cityList.add(new City("Rotterdam","The Hague",  "Netherlands"));
    	cityList.add(new City("Amsterdam", "Haarlem", "Netherlands"));
    	cityList.add(new City("Maastricht", "Maastricht", "Netherlands"));

    	return this.cityList;
    }
}