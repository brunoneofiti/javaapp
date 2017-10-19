package br.com.brunoneofiti.app.atm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.atm.model.Geolocation;

@Repository 
public class AddressDAO {
	
	private Log log = LogFactory.getLog(AddressDAO.class);
	
	private List<Address> addressList;
	
	/**
	 * 
	 * @param cityname
	 * @return
	 */
	public List<Address> getAddressesOfOneCity(String cityname) {

		this.addressList = new ArrayList<Address>();
		
		if(cityname == null) {
			if(log.isDebugEnabled()){
				log.debug("cityname is null, returning empty list of Address");
			}
			return new ArrayList<Address>();
		}
		
    	for (Address a : getAddressesFromDatabase()) {
			if(a.getCity().equalsIgnoreCase(cityname)) {
				this.addressList.add(a);
			}
		}
    	
		return this.addressList;
	}
	
	/**
	 * 
	 * @return
	 */
    public List<Address> getAddressesFromDatabase() {
    	
    	List<Address> addressList = new ArrayList<Address>();
		
    	addressList = addToAddressList();
    	
    	//add more data, just to test
    	for(int i=0; i<100; i++){
    		addressList.addAll(addToAddressList());
    	}
    	
    	return addressList;
	}
    
    /**
     * 
     * @return
     */
    private List<Address> addToAddressList(){
    	
		this.addressList = new ArrayList<Address>();
		
    	this.addressList.add(new Address("Street One", "35", "05320-310", "Utrecht", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Two", "2", "05320-310", "Utrecht", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Five", "5", "05320-310", "Utrecht", new Geolocation("111223","55321")));

    	this.addressList.add(new Address("Street One", "35", "05320-310", "Eindhoven", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Two", "2", "05320-310", "Eindhoven", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Five", "5", "05320-310", "Eindhoven", new Geolocation("111223","55321")));

    	this.addressList.add(new Address("Street One", "35", "05320-310", "Rotterdam", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Two", "2", "05320-310", "Rotterdam", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Five", "5", "05320-310", "Rotterdam", new Geolocation("111223","55321")));

    	this.addressList.add(new Address("Street One", "35", "05320-310", "Haia", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Two", "2A", "05320-310", "Haia", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Five", "A5", "05320-310", "Haia", new Geolocation("111223","55321")));
    	
    	this.addressList.add(new Address("Street One", "35", "05320-310", "Maastricht", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Two", "2", "05320-310", "Maastricht", new Geolocation("111223","55321")));
    	this.addressList.add(new Address("Street Five", "5", "05320-310", "Maastricht", new Geolocation("111223","55321")));

    	return this.addressList;
    }
    
    
    /**
     * 
     * @return
     */
    public List<Address> getAddressList(){
    	return this.addressList;
    }
    
}