package com.backbase.assignment.mainPage.model;

import com.backbase.assignment.dutchCities.model.City;

public class Address {

	private String street;
	private int housenumber;
	private String postalcode;
	private City city;
	private Geolocation geo;
	private int distance;
	private String type;
	

	public Address(String street, int housenumber, String postalcode, City city, Geolocation geo, int distance, String type) {
		this.street = street;
		this.housenumber = housenumber;
		this.postalcode = postalcode;
		this.city = city;
		this.geo = geo;
		this.distance = distance;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", housenumber=" + housenumber + ", postalcode=" + postalcode + ", city="
				+ city + ", geo=" + geo + ", distance=" + distance + ", type=" + type + "]";
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Geolocation getGeo() {
		return geo;
	}
	public void setGeo(Geolocation geo) {
		this.geo = geo;
	}

}