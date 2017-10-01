package com.backbase.assignment.dutchCities.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    private final String name;
    private final String provinces;
    private final String country;
	
    public City(@JsonProperty("name") String name) {
        this.name = name;
        this.provinces = null;
        this.country = null;
    }
    
    public City(String name, String provinces,String country) {
        this.name = name;
        this.country = country;
        this.provinces = provinces;
    }
    

	@Override
	public String toString() {
		return "City [name=" + name + ", provinces=" + provinces + ", country=" + country + "]";
	}


	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}


	public String getProvinces() {
		return provinces;
	}
    
    
    /*
     * {"address":{"street":"Reeweg","housenumber":"88","postalcode":"3342 AC","city":"Hendrik-Ido-Ambacht","geoLocation":{"lat":"51.845284","lng":"4.63029"}},"distance":0,"type":"ING"}
     * */
    
    
}