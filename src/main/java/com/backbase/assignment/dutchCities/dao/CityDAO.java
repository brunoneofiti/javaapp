package com.backbase.assignment.dutchCities.dao;

import java.util.ArrayList;
import java.util.List;

import com.backbase.assignment.dutchCities.model.City;

public class CityDAO {
	
	List<City> cities;
	
	public City getCity() {
		cities = getCities();
		return cities.get(0);
	}
	
    public List<City> getCities() {
    	
    	City city1 = new City("Utrecht", "Utrecht", "Netherlands");
    	City city2 = new City("Eindhoven","Hertogenbosch",  "Netherlands");
    	City city3 = new City("Rotterdam","The Hague",  "Netherlands");
    	City city4 = new City("Amsterdam", "Haarlem", "Netherlands");
    	City city5 = new City("Maastricht", "Maastricht", "Netherlands");
    	
    	List<City> cities = new ArrayList<City>();
    	
    	cities.add(city1);
    	cities.add(city2);
    	cities.add(city3);
    	cities.add(city4);
    	cities.add(city5);
    	
    	return cities;
	}

    
    
}