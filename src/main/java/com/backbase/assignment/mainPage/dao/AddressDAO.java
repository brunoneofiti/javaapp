package com.backbase.assignment.mainPage.dao;

import java.util.ArrayList;
import java.util.List;

import com.backbase.assignment.dutchCities.model.City;
import com.backbase.assignment.mainPage.model.Address;
import com.backbase.assignment.mainPage.model.Geolocation;

public class AddressDAO {
	
	List<Address> addressList;
	
	public List<Address> getAddressesOfOneCity(String cityname) {
		
		if(cityname == null) {
			return new ArrayList<Address>();
		}
		
    	List<Address> list = new ArrayList<Address>();

    	for (Address a : getAddressesFromDatabase()) {
			if(a.getCity().getName().equalsIgnoreCase(cityname)) {
				list.add(a);
			}
		}
    	
		return list;
	}
	
    public List<Address> getAddressesFromDatabase() {
    	
    	List<Address> addresses = new ArrayList<Address>();
    	
    	City utrecht = new City("Utrecht", "Utrecht", "Netherlands");
    	Geolocation utrechtGeo = new Geolocation("111223","55321");
    	Address utrechtAddress1 = new Address("Street One", 35, "05320-310", utrecht, utrechtGeo, 10, "ING");
    	Address utrechtAddress2 = new Address("Street Two", 2, "05320-310", utrecht, utrechtGeo, 10, "ING");
    	Address utrechtAddress3 = new Address("Street Five", 5, "05320-310", utrecht, utrechtGeo, 10, "ING");
    	
    	addresses.add(utrechtAddress1);
    	addresses.add(utrechtAddress2);
    	addresses.add(utrechtAddress3);

    	City eindhoven = new City("Eindhoven","Hertogenbosch",  "Netherlands");
    	Geolocation eindhovenGeo = new Geolocation("111223","55321");
    	Address eindhovenAddress1 = new Address("Street One", 35, "05320-310", eindhoven, eindhovenGeo, 10, "ING");
    	Address eindhovenAddress2 = new Address("Street Two", 2, "05320-310", eindhoven, eindhovenGeo, 10, "ING");
    	Address eindhovenAddress3 = new Address("Street Five", 5, "05320-310", eindhoven, eindhovenGeo, 10, "ING");
    	
    	addresses.add(eindhovenAddress1);
    	addresses.add(eindhovenAddress2);
    	addresses.add(eindhovenAddress3);

    	City rotterdam = new City("Rotterdam","The Hague",  "Netherlands");
    	Geolocation rotterdamGeo = new Geolocation("111223","55321");
    	Address rotterdamAddress1 = new Address("Street One", 35, "05320-310", rotterdam, rotterdamGeo, 10, "ING");
    	Address rotterdamAddress2 = new Address("Street Two", 2, "05320-310", rotterdam, rotterdamGeo, 10, "ING");
    	Address rotterdamAddress3 = new Address("Street Five", 5, "05320-310", rotterdam, rotterdamGeo, 10, "ING");
    	
    	addresses.add(rotterdamAddress1);
    	addresses.add(rotterdamAddress2);
    	addresses.add(rotterdamAddress3);

    	City haia = new City("Haia", "Haarlem", "Netherlands");
    	Geolocation haiaGeo = new Geolocation("111223","55321");
    	Address haiaAddress1 = new Address("Street One", 35, "05320-310", haia, haiaGeo, 10, "ING");
    	Address haiaAddress2 = new Address("Street Two", 2, "05320-310", haia, haiaGeo, 10, "ING");
    	Address haiaAddress3 = new Address("Street Five", 5, "05320-310", haia, haiaGeo, 10, "ING");
    	
    	addresses.add(haiaAddress1);
    	addresses.add(haiaAddress2);
    	addresses.add(haiaAddress3);

    	
    	City maastricht = new City("Maastricht", "Maastricht", "Netherlands");
    	Geolocation maastrichtGeo = new Geolocation("111223","55321");
    	Address maastrichtAddress1 = new Address("Street One", 35, "05320-310", maastricht, maastrichtGeo, 10, "ING");
    	Address maastrichtAddress2 = new Address("Street Two", 2, "05320-310", maastricht, maastrichtGeo, 10, "ING");
    	Address maastrichtAddress3 = new Address("Street Five", 5, "05320-310", maastricht, maastrichtGeo, 10, "ING");
    	

    	addresses.add(maastrichtAddress1);
    	addresses.add(maastrichtAddress2);
    	addresses.add(maastrichtAddress3);

    	return addresses;
	}
    
    public List<Address> getAddressList(){
    	return this.addressList;
    }
    
    
    
}