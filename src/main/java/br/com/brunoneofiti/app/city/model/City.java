package br.com.brunoneofiti.app.city.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    private String name;
    private String provinces;
    private String country;
	
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
    
}