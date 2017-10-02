package com.backbase.assignment.mainPage.dao;

import java.util.ArrayList;
import java.util.List;

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
			if(a.getCity().equalsIgnoreCase(cityname)) {
				list.add(a);
			}
		}
    	
		return list;
	}
	
    public List<Address> getAddressesFromDatabase() {
    	
    	List<Address> addresses = new ArrayList<Address>();
    	
    	Geolocation utrechtGeo = new Geolocation("111223","55321");
    	Address utrechtAddress1 = new Address("Street One", "35", "05320-310", "Utrecht", utrechtGeo );
    	Address utrechtAddress2 = new Address("Street Two", "2", "05320-310", "Utrecht", utrechtGeo);
    	Address utrechtAddress3 = new Address("Street Five", "5", "05320-310", "Utrecht", utrechtGeo);
    	
    	addresses.add(utrechtAddress1);
    	addresses.add(utrechtAddress2);
    	addresses.add(utrechtAddress3);

    	Geolocation eindhovenGeo = new Geolocation("111223","55321");
    	Address eindhovenAddress1 = new Address("Street One", "35", "05320-310", "Eindhoven", eindhovenGeo);
    	Address eindhovenAddress2 = new Address("Street Two", "2", "05320-310", "Eindhoven", eindhovenGeo);
    	Address eindhovenAddress3 = new Address("Street Five", "5", "05320-310", "Eindhoven", eindhovenGeo);
    	
    	addresses.add(eindhovenAddress1);
    	addresses.add(eindhovenAddress2);
    	addresses.add(eindhovenAddress3);

    	Geolocation rotterdamGeo = new Geolocation("111223","55321");
    	Address rotterdamAddress1 = new Address("Street One", "35", "05320-310", "Rotterdam", rotterdamGeo);
    	Address rotterdamAddress2 = new Address("Street Two", "2", "05320-310", "Rotterdam", rotterdamGeo);
    	Address rotterdamAddress3 = new Address("Street Five", "5", "05320-310", "Rotterdam", rotterdamGeo);
    	
    	addresses.add(rotterdamAddress1);
    	addresses.add(rotterdamAddress2);
    	addresses.add(rotterdamAddress3);

    	Geolocation haiaGeo = new Geolocation("111223","55321");
    	Address haiaAddress1 = new Address("Street One", "35", "05320-310", "Haia", haiaGeo);
    	Address haiaAddress2 = new Address("Street Two", "2A", "05320-310", "Haia", haiaGeo);
    	Address haiaAddress3 = new Address("Street Five", "A5", "05320-310", "Haia", haiaGeo);
    	
    	addresses.add(haiaAddress1);
    	addresses.add(haiaAddress2);
    	addresses.add(haiaAddress3);
    	
    	Geolocation maastrichtGeo = new Geolocation("111223","55321");
    	Address maastrichtAddress1 = new Address("Street One", "35", "05320-310", "Maastricht", maastrichtGeo);
    	Address maastrichtAddress2 = new Address("Street Two", "2", "05320-310", "Maastricht", maastrichtGeo);
    	Address maastrichtAddress3 = new Address("Street Five", "5", "05320-310", "Maastricht", maastrichtGeo);

    	addresses.add(maastrichtAddress1);
    	addresses.add(maastrichtAddress2);
    	addresses.add(maastrichtAddress3);

    	return addresses;
	}
    
    public List<Address> getAddressList(){
    	return this.addressList;
    }
    
    
    
}