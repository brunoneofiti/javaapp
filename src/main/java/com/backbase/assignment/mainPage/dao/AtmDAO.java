package com.backbase.assignment.mainPage.dao;

import java.util.ArrayList;
import java.util.List;

import com.backbase.assignment.mainPage.model.ATM;
import com.backbase.assignment.mainPage.model.Address;

public class AtmDAO {
	
	List<ATM> atmList;
	
    public List<ATM> getAtmFromDatabase() {
    	
    	AddressDAO dao = new AddressDAO();
    	
    	List<Address> addresses = dao.getAddressesFromDatabase();

    	List<ATM> atmList = new ArrayList<ATM>();
    	
    	for(Address address: addresses){
    		
    		if(address != null){
    			ATM atm = new ATM(address, 0, "ING");
    			atmList.add(atm);
    		}
    	}
    	
    	
    	return atmList;
	}
    
    public List<ATM> getAtmList(){
    	return this.atmList;
    }
    
    
    
}