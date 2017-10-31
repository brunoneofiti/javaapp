package br.com.brunoneofiti.app.geolocation.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.common.business.BusinessException;

@Component
public class MapBusiness {
       
	private Log log = LogFactory.getLog(MapBusiness.class);
	
	@Autowired
	private AtmDAO atmDAO;

	public ATM getOneATM(){
		
		List<ATM> ATMlist = new ArrayList<ATM>();
		
		try {
			
			ATMlist = atmDAO.getAtmFromDatabase();
			
		} catch (BusinessException e) {
			
			log.error("error calling database (in fact json file) ");
			e.printStackTrace();
		}
		
		return ATMlist.get(0);
	}

}