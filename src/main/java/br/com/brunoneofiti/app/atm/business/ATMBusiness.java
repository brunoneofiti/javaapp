package br.com.brunoneofiti.app.atm.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.atm.model.Geolocation;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Component
public class ATMBusiness {
       
	private Log log = LogFactory.getLog(ATMBusiness.class);
	
	@Autowired
	private AtmDAO dao;

	private	List<ATM> atmList;

	
	/**
	 * @return All Atms from my database
	 * @throws BusinessException
	 */
	public List<ATM> getAllATMs() throws BusinessException{
	
		//validate ATMs from database
		checkAtms();
		
		return dao.getAtmFromDatabase();
	}
	
	
	/**
	 * 
	 * @param json
	 * @return
	 * @throws BusinessException
	 */
	public List<ATM> createCityValidate(String json) throws BusinessException{
    	
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			City city = mapper.readValue(json, City.class);
			
			atmList = new ArrayList<ATM>();
			
			atmList = dao.getAtmFromDatabase();
			
			//add City to list 
			atmList.add(new ATM(new Address("Avenue Main", "10", "00545", city.getName(), new Geolocation("12", "33")), 10, "ING"));
	    	
		} catch (JsonParseException e) {
			log.error("JsonParseException problem");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			log.error("JsonMappingException problem");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException problem");
			e.printStackTrace();
		}
    	
    	return atmList;
	}
	
	
	
	/**
	 * If you didnt pass cityname
	 * Consult "Database" and return name of all cities of ATM JSON
	 * 
	 * If you pass the city name.
	 * Consult "Database" and check if it exist in the list, then, If is true return cityname, if is false return BusinessException
	 * 
	 * @param cityname 
	 * @param atmList
	 * @return
	 * @throws BusinessException
	 */
	public List<String> getCityByATMList(String cityname) throws BusinessException{
		
		Set<String> citySet = new HashSet<String>();
		
		//check for valid cities and add it to HashSet
		for(ATM atm : dao.getAtmFromDatabase()){
			
			if(atm == null){
				throw new BusinessException("Empty ATM");
				
			}else if(atm.getAddress() == null){
				throw new BusinessException("Empty Address");
				
			}else if(atm.getAddress().getCity() == null){
				throw new BusinessException("Empty City");
				
			}else{
				
				citySet.add(atm.getAddress().getCity());
			}
		}
		
		List<String> cityList = new ArrayList<String>(); 
		
		if(cityname.equals("all")){
			
			cityList.addAll(citySet);
			
		}else if(citySet.contains(cityname)){
			
			cityList.add(cityname);
		}else {
			
			throw new BusinessException("City not found");
		}
		
		return cityList;
		
	}
	
	/**
	 * 
	 * @param dao
	 * @throws BusinessException
	 */
	public void checkAtms() throws BusinessException{
		
		if(log.isDebugEnabled()){
			log.debug("getAtmList:" + dao.getAtmFromDatabase());
			log.debug("getAtmFromDatabase:" + dao.getAtmFromDatabase());
		}

		
		//Business Rule
		if(dao.getAtmFromDatabase() == null){
	        throw new BusinessException("Cannot find an ATM!");
		}
	}

	
	/**
	 * 
	 * @param dao
	 * @throws BusinessException
	 */
	public void checkCities(CityDAO dao) throws BusinessException{
		
		//Business Rule
		if(dao.getCitiesFromDatabase() == null || dao.getCity() == null){
	        
			if(log.isDebugEnabled()){
				log.debug("getCities:" + dao.getCitiesFromDatabase());
				log.debug("getCity:" + dao.getCity());
			}
			
			throw new BusinessException("Cannot call city!");
		}
	}


	/**
	 * Validate if all Addresses are valid in database
	 * @param dao
	 * @throws BusinessException
	 */
	public void checkAddress(AddressDAO dao) throws BusinessException{
		
		if(log.isDebugEnabled()){
			log.debug("getAddressList:" + dao.getAddressList());
			log.debug("getAddressesFromDatabase:" + dao.getAddressesFromDatabase());
		}
		
		//Business Rule
		if(dao.getAddressesFromDatabase() == null){
	        throw new BusinessException("Cannot find an address!");
		}
	}

	
}
