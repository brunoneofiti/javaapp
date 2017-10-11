package br.com.brunoneofiti.app.atm.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.common.business.BusinessException;

public class ATMBusiness {
       
	private Log log = LogFactory.getLog(ATMBusiness.class);
	
	
	public void checkCities(CityDAO dao) throws BusinessException{
		
		//Business Rule
		if(dao.getCities() == null || dao.getCity() == null){
	        
			if(log.isDebugEnabled()){
				log.debug("getCities:" + dao.getCities());
				log.debug("getCity:" + dao.getCity());
			}
			
			throw new BusinessException("Cannot call city!");
		}
	}
	

	public void checkAtms(AtmDAO dao) throws BusinessException{
		
		if(log.isDebugEnabled()){
			log.debug("getAtmList:" + dao.getAtmList());
			log.debug("getAtmFromDatabase:" + dao.getAtmFromDatabase());
		}

		
		//Business Rule
		if(dao.getAtmList() == null || dao.getAtmFromDatabase() == null){
	        throw new BusinessException("Cannot find an ATM!");
		}
	}

	public void checkAddress(AddressDAO dao) throws BusinessException{
		
		if(log.isDebugEnabled()){
			log.debug("getAddressList:" + dao.getAddressList());
			log.debug("getAddressesFromDatabase:" + dao.getAddressesFromDatabase());
		}
		
		//Business Rule
		if(dao.getAddressList() == null || dao.getAddressesFromDatabase() == null){
	        throw new BusinessException("Cannot find an address!");
		}
	}

	
}
