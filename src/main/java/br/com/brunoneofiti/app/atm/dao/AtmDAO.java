package br.com.brunoneofiti.app.atm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.login.controller.LoginController;

@Repository 
public class AtmDAO {
	
	private Log log = LogFactory.getLog(LoginController.class);
	
	private AddressDAO addressDAO;

	/**
	 * Simulate access to a database
	 * @return list of ATMs
	 */
    public List<ATM> getAtmFromDatabase() {
    	
    	List<ATM> atmList = new ArrayList<ATM>();
    	
    	try{

    		addressDAO = new AddressDAO();
    		
    		for(Address address: addressDAO.getAddressesFromDatabase()){
        		
        		if(address != null){
        			ATM atm = new ATM(address, 0, "ING");
        			atmList.add(atm);
        		}
        	}

    		
    	}catch (Exception e) {
    		log.error("Business Exception");
    		log.error(e.getMessage());
		}
    	
    	return atmList;
	}
    
}