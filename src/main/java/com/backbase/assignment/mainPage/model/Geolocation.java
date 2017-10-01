package com.backbase.assignment.mainPage.model;

public class Geolocation {

	private String lat;
	private String lon;
	
	public Geolocation (String lat, String lon) {
		this.lat = lat;
		this.lon = lon;
	}
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	@Override
	public String toString() {
		return "Geolocation [lat=" + lat + ", lon=" + lon + "]";
	}
	
	

}