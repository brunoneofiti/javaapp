package br.com.brunoneofiti.app.city.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.brunoneofiti.app.city.model.City;

public class CityDAO {
	
	List<City> cities;
	
	public City getCity() {

		cities = new ArrayList<City>();

		cities = getCities();
		
		return this.cities.get(0);
	}
	
    public List<City> getCities() {
    	
		cities = new ArrayList<City>();
		
    	cities = addToCityList();
    	
    	// just to add more data to the POC 
    	cities.addAll(addToCityList());
    	cities.addAll(addToCityList());
    	cities.addAll(addToCityList());
    	cities.addAll(addToCityList());
    	cities.addAll(addToCityList());
    	
    	return this.cities;
	}
    
    
    private List<City> addToCityList(){
    	
		cities = new ArrayList<City>();
		
    	cities.add(new City("Utrecht", "Utrecht", "Netherlands"));
    	cities.add(new City("Eindhoven","Hertogenbosch",  "Netherlands"));
    	cities.add(new City("Rotterdam","The Hague",  "Netherlands"));
    	cities.add(new City("Amsterdam", "Haarlem", "Netherlands"));
    	cities.add(new City("Maastricht", "Maastricht", "Netherlands"));

    	return this.cities;
    }
}