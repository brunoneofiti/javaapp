package com.backbase.assignment.mainPage.model;

public class Address {

	private String street;
	private String housenumber;
	private String postalcode;
	private String city;
	private Geolocation geoLocation;
	
	public Address(String street, String housenumber, String postalcode, String city, Geolocation geoLocation) {
		this.street = street;
		this.housenumber = housenumber;
		this.postalcode = postalcode;
		this.city = city;
		this.geoLocation = geoLocation;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Geolocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(Geolocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", housenumber=" + housenumber + ", postalcode=" + postalcode + ", city="
				+ city + ", geoLocation=" + geoLocation + "]";
	}
	
}