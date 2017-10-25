package br.com.brunoneofiti.app.atm.business;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Component
public class AddressBusiness {
       
	private Log log = LogFactory.getLog(AddressBusiness.class);
	
	@Autowired
	private AddressDAO dao;

	/**
	 * @return All Atms from my database
	 * @throws BusinessException
	 */
	public List<Address> getAllAddresses() throws BusinessException{
	
		//validate ATMs from database
		checkAddress();
		
		return dao.getAddressesFromDatabase();
	}


	/**
	 * Validate if all Addresses are valid in database
	 * @param dao
	 * @throws BusinessException
	 */
	public void checkAddress() throws BusinessException{
		
		if(log.isDebugEnabled()){
			log.debug("getAddressList:" + dao.getAddressesFromDatabase());
			log.debug("getAddressesFromDatabase:" + dao.getAddressesFromDatabase());
		}
		
		//Business Rule
		if(dao.getAddressesFromDatabase() == null){
	        throw new BusinessException("Cannot find an address!");
		}
	}

	
}
