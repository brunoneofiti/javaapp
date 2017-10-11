package br.com.brunoneofiti.app.atm.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brunoneofiti.app.atm.model.ATM;

@Controller
public class ATMService {

	private Log log = LogFactory.getLog(ATMService.class);
	
	/**
	 * Public WS.
	 * List ATM by cityname, call local web service
	 * @return
	 */
	@RequestMapping(value = "/ws", method = RequestMethod.GET)
	public ModelAndView getLocalWS() {

//OK
//		String url = ""https://www.ing.nl/api/locator/atms"";
//		String url = "http://localhost:8080/javaapp/ws/getAtmList"; 
//		callRest(url);

		String file = "c\\apps\\workspace-neon\\brunoneofiti\\javaapp\\src\\main\\java\\com\\backbase\\assignment\\atm\\dao\\data.json";
		
		callJson(file);
		
		ModelAndView model = new ModelAndView();
		model.addObject("title", "JavaApp Title");
		model.addObject("content", "See list.");
		model.setViewName("main");

		return model;
	}
	
	
	private void callJson(String filename) {

		ObjectMapper mapper = new ObjectMapper();
		
		TypeReference<ATM> mapType = new TypeReference<ATM>() {};
		
		InputStream inputStream = TypeReference.class.getResourceAsStream(filename);
		
		try {
			
			ATM atm = mapper.readValue(inputStream, mapType);
			
			log.info("callJson 1");
			
			System.out.println(atm.toString());
			
		} catch (IOException e) {

			log.info("callJson bad 1");
			log.info(e.getMessage());
		}
		
		//
		
		log.info("callJson 2");
		ATM atm = null;
		
		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);

		try {
			
			log.info("callJson 2.1");
		    String str = inputStream.toString(); 
			log.info("callJson 2.2");
		    
		    atm = mapper.readValue(str, ATM.class); 
		    
			log.info(atm.toString());
		    
		} catch (Exception e) {
			
			log.info("bad 2");
			log.info(e.getMessage());
		}
	}

	
    /**
     * Call a JSON/REST web service
     * @param url
     */
	private void callRest(String url) {
    
    	RestTemplate restTemplate = new RestTemplate();

    	try {
    		
    		Object obj = restTemplate.getForObject(url, Object.class);
    		
			log.info("result:" + obj.toString());
    		
    	}catch (Exception e) {
    		
			log.error(e.getMessage());
	}
	

}
