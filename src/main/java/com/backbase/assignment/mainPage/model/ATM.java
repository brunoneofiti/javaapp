package com.backbase.assignment.mainPage.model;

public class ATM {
	
	private Address address;
	private int distance;
	private String type;
	

	public ATM(Address address, int distance, String type) {
		this.address = address;
		this.distance = distance;
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "ATM [address=" + address + ", distance=" + distance + ", type=" + type + "]";
	}

}
