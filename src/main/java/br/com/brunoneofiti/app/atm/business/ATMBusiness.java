package br.com.brunoneofiti.app.atm.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.atm.model.Geolocation;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Component
public class ATMBusiness {
       
	private Log log = LogFactory.getLog(ATMBusiness.class);
	
	@Autowired
	private AtmDAO atmDAO;

	private	List<ATM> atmList;

	/**
	 * Read File
	 * @param filename
	 * @return
	 */
	public List<ATM> callJsonLocalFile() {
		
		List<ATM> atmList = new ArrayList<ATM>();
		
        InputStream inputStream;
        
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			
			inputStream = new FileInputStream(new File(classLoader.getResource("data//data.json").getFile()));
			
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	        StringBuilder stringBuilder = new StringBuilder();
	        
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	        	
	        	if(!line.equals(")]}',")){
	        		stringBuilder.append(line);
	        	}
	        }
	        
	        reader.close();
	        
	        ObjectMapper mapper = new ObjectMapper();

	        atmList = mapper.readValue(stringBuilder.toString(), new TypeReference<List<ATM>>(){});
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return atmList;
	}

	
    /**
     * Call a JSON/REST web service
     * @param url
     */
	public List<ATM> callRest(String url) {
    
		List<ATM> atmList = new ArrayList<ATM>();
		
    	RestTemplate restTemplate = new RestTemplate();

    	try {

    		String obj = restTemplate.getForObject(url, String.class);
			
	        StringBuilder stringBuilder = new StringBuilder();

	        stringBuilder.append(obj.toString());
	        
	        ObjectMapper mapper = new ObjectMapper();

	        atmList = mapper.readValue(stringBuilder.toString(), new TypeReference<List<ATM>>(){});
			
    	}catch (Exception e) {
    		
			log.error(e.getMessage());
    	}
    	
		return atmList;
	}

	
	/**
	 * @return All Atms from my database
	 * @throws BusinessException
	 */
	public List<ATM> getAllATMs() throws BusinessException{
	
		return atmDAO.getAtmFromDatabase();
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
			
			atmList = atmDAO.getAtmFromDatabase();
			
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
	 * 
	 * @param atmDAO
	 * @throws BusinessException
	 */
	public void checkAtms() throws BusinessException{
		
		if(log.isDebugEnabled()){
			log.debug("getAtmList:" + atmDAO.getAtmFromDatabase());
			log.debug("getAtmFromDatabase:" + atmDAO.getAtmFromDatabase());
		}

		//Business Rule
		if(atmDAO.getAtmFromDatabase() == null) throw new BusinessException("Cannot find an ATM!");
	}
}
