package br.com.brunoneofiti.app.atm.dao;

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
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Repository 
public class AtmDAO {
	
	private Log log = LogFactory.getLog(AtmDAO.class);
	
	private AddressDAO addressDAO;

	/**
	 * Simulate access to a database
	 * @return list of ATMs
	 * @throws BusinessException 
	 */
    public List<ATM> getAtmFromDatabase() throws BusinessException {
    	
		List<ATM> atmList = new ArrayList<ATM>();
		
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			
			InputStream inputStream = new FileInputStream(new File(classLoader.getResource("data//data.json").getFile()));
			
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
			e.getMessage();
			log.error("Cannot access JSON file");
			
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
			log.error("Cannot aread JSON file");
		}
		
		return atmList;
    }
	
	/**
	 * Simulate access to a database
	 * @return list of ATMs
	 */
    public List<ATM> getAtmFromDB() {
    	
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