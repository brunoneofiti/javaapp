package br.com.brunoneofiti.app.atm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Repository 
public class AddressDAO {
	
	private Log log = LogFactory.getLog(AddressDAO.class);
	
	private	AtmDAO AtmDAO;

	
	/**
	 * 
	 * @param cityname
	 * @return
	 */
	public List<Address> getAddressesOfOneCity(String cityname) {

		List<Address> addressList = new ArrayList<Address>();
		
		if(cityname == null) {
			if(log.isDebugEnabled()){
				log.debug("cityname is null, returning empty list of Address");
			}
			return new ArrayList<Address>();
		}
		
    	for (Address a : getAddressesFromDatabase()) {
			if(a.getCity().equalsIgnoreCase(cityname)) {
				addressList.add(a);
			}
		}
    	
		return addressList;
	}
    
    /**
     * 
     * @return
     */
    public List<Address> getAddressesFromDatabase(){
    	
    	List<Address> addressList = new ArrayList<Address>();

		try {
			
			AtmDAO = new AtmDAO();
			
			List<ATM> atmList = AtmDAO.getAtmFromDatabase();
	    	
			for(ATM atm : atmList){
	    		
	        	addressList.add(atm.getAddress());
	    	}
			
		} catch (BusinessException e) {
			
			e.printStackTrace();
		}

    	return addressList;
    }
    
}