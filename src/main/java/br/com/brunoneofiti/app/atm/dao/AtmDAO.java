package br.com.brunoneofiti.app.atm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.login.controller.LoginController;

public class AtmDAO {
	
	private Log log = LogFactory.getLog(LoginController.class);
	
	private List<ATM> atmList = new ArrayList<ATM>();

	/**
	 * Simulate access to a database
	 * @return list of ATMs
	 */
    public List<ATM> getAtmFromDatabase() {
    	
    	AddressDAO dao = new AddressDAO();
    	
    	try{

        	for(Address address: dao.getAddressesFromDatabase()){
        		
        		if(address != null){
        			ATM atm = new ATM(address, 0, "ING");
        			this.atmList.add(atm);
        		}
        	}

    		
    	}catch (Exception e) {
    		log.error("Business Exception");
    		log.error(e.getMessage());
		}
    	
    	
    	return this.atmList;
	}
    
    public List<ATM> getAtmList(){
    	return this.atmList;
    }
    
}