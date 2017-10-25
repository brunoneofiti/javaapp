package br.com.brunoneofiti.app.atm.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunoneofiti.app.atm.business.ATMBusiness;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.common.business.BusinessException;

@RestController
public class ATMService {

	@Autowired
	private ATMBusiness business;
	
	/**
	 * Public WS.
	 * List ATM by cityname, call local web service
	 * @return
	 */
	@RequestMapping(value = "/ws", method = RequestMethod.GET)
	public List<ATM> getLocalWS() {

//		String url = ""https://www.ing.nl/api/locator/atms"";
		String url = "http://localhost:8080/javaapp/ws/getAtmList"; 
		
		business.callRest(url);
		
    	return business.callJson();
	}



	/**
	 * Public WS.
	 * List ATM by cityname
	 * @param cityname
	 * @return
	 * @throws BusinessException 
	 */
    @RequestMapping("/ws/getAtmList")
    public List<ATM> getAtmList() 
    		throws BusinessException {
        
		return business.getAllATMs();
    }
    
	/**
	 * Public WS
	 * Create ATM passing JSON
	 * @param json
	 * @return
	 * @throws BusinessException 
	 */
    @RequestMapping("/ws/createAtm")
    public @ResponseBody List<ATM> createAtm(@RequestParam(value="json") String json) throws BusinessException {
        
		return business.createCityValidate(json);
    }
}