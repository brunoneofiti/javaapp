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
	
	private Log log = LogFactory.getLog(ATMBusiness.class);

	/**
	 * Public WS.
	 * List ATM. Call remote web service (could not work if the WS is offline)
	 * @return
	 */
	@RequestMapping(value = "/ws/getRemoteWS", method = RequestMethod.GET)
	public List<ATM> getRemoteWS() {

		List<ATM> list = business.callRest("https://www.ing.nl/api/locator/atms");
		
		log.info("third try - Remote WS");
		log.info("file size:" + list.size());
		
    	return list;
	}

	
	/**
	 * Public WS.
	 * List ATM. Call local web service (copy of the return of the remote WS)
	 * @return
	 */
	@RequestMapping(value = "/ws/getLocalWS", method = RequestMethod.GET)
	public List<ATM> getLocalWS() {

		List<ATM> list = business.callRest("http://localhost:8080/javaapp/ws/getAtmList");
		
		log.info("second try - Local WS");
		log.info("file size:" + list.size());
		
    	return list;
	}

	/**
	 * Public WS.
	 * List ATM. Call local json file (copy of the return of the remote WS)
	 * @return
	 */
	@RequestMapping(value = "/ws/getLocalFile", method = RequestMethod.GET)
	public List<ATM> getLocalFileWS() {

		List<ATM> list = business.callJsonLocalFile();
		
		log.info("first try - Local json file");
		log.info("file size:" + list.size());
		
    	return list;
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