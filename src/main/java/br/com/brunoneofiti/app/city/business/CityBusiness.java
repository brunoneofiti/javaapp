package br.com.brunoneofiti.app.city.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Component
public class CityBusiness {
       
	private Log log = LogFactory.getLog(CityBusiness.class);
	
	@Autowired
	private AtmDAO atmDAO;

	@Autowired
	private CityDAO cityDAO;

	
	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<City> getAllCities() throws BusinessException{
	
		checkCities(cityDAO);
		
		Set<City> citySet = new HashSet<City>(cityDAO.getCitiesFromDatabase());
		
		if(citySet.size() > 0) return new ArrayList<City>(citySet);
		
		return cityDAO.getCitiesFromDatabase();
	}
	
	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public City getOneCity(String name) throws BusinessException{
	
		checkCities(cityDAO);
		
		return cityDAO.getCity(name);
	}
	
	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public City getOneCity() throws BusinessException{
	
		checkCities(cityDAO);
		
		return cityDAO.getCity();
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
		for(ATM atm : atmDAO.getAtmFromDatabase()){
			
			if(atm == null)
				throw new BusinessException("Empty ATM");
			else if(atm.getAddress() == null)
				throw new BusinessException("Empty Address");
			else if(atm.getAddress().getCity() == null)
				throw new BusinessException("Empty City");
			else
				citySet.add(atm.getAddress().getCity());
				
		}
		
		List<String> cityList = new ArrayList<String>(); 
		
		if("all".equals(cityname)) 
			cityList.addAll(citySet); 
		else if(citySet.contains(cityname))
			cityList.add(cityname);
		else
			throw new BusinessException("City not found");
		
		return cityList.stream().sorted().collect(Collectors.toList());
	}
	
	
	/**
	 * 
	 * @param dao
	 * @throws BusinessException
	 */
	public void checkCities(CityDAO dao) throws BusinessException{
		
		if(log.isDebugEnabled()){
			log.debug("getCities:" + dao.getCitiesFromDatabase());
			log.debug("getCity:" + dao.getCity());
		}
		
		//Business Rule
		if(dao.getCitiesFromDatabase() == null) throw new BusinessException("Cannot call city!"); 
	}
	
}
