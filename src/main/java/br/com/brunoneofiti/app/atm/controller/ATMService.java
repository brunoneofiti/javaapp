package br.com.brunoneofiti.app.atm.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brunoneofiti.app.atm.model.ATM;

@RestController
public class ATMService {

	private Log log = LogFactory.getLog(ATMService.class);
	
	/**
	 * Public WS.
	 * List ATM by cityname, call local web service
	 * @return
	 */
	@RequestMapping(value = "/ws", method = RequestMethod.GET)
	public List<ATM> getLocalWS() {

//		String url = ""https://www.ing.nl/api/locator/atms"";
		
		String url = "http://localhost:8080/javaapp/ws/getAtmList"; 
		callRest(url);
		
		String file = "c://apps//workspace-neon//brunoneofiti//javaapp//src//main//java//br//com//brunoneofiti//app//atm//dao//data.json";	
    	return callJson(file);
	}
	
    /**
     * Call a JSON/REST web service
     * @param url
     */
	private void callRest(String url) {
    
		List<ATM> atmList = new ArrayList<ATM>();
		
    	RestTemplate restTemplate = new RestTemplate();

    	try {
    		
    		Object obj = restTemplate.getForObject(url, Object.class);
    		
			log.info("result:" + obj.toString());
			
	        StringBuilder stringBuilder = new StringBuilder();

	        stringBuilder.append(obj.toString());
			
			ObjectMapper mapper = new ObjectMapper();
	        
	        atmList = mapper.readValue(stringBuilder.toString(), new TypeReference<List<ATM>>(){});

			log.info(atmList.toString());
			
    	}catch (Exception e) {
    		
			log.error(e.getMessage());
    	}
	}
	
	/**
	 * Read File
	 * @param filename
	 * @return
	 */
	private List<ATM> callJson(String filename) {

		List<ATM> atmList = new ArrayList<ATM>();
		
        InputStream inputStream;
        
		try {
			
			inputStream = new FileInputStream(new File(filename));
			
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

	
}