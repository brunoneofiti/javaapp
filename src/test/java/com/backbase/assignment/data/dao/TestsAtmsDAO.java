package com.backbase.assignment.data.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.atm.model.Geolocation;

public class TestsAtmsDAO {

	private Log log = LogFactory.getLog(TestsAtmsDAO.class);
	
	public void create(){
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			Address address1 = new Address("Reeweg", "88", "3342 AC", "Hendrik-Ido-Ambacht", new Geolocation("51.845284","4.63029"));
			Address address2 = new Address("Grote Markt", "14A", "4461 AJ", "Goes", new Geolocation("51.504808","3.890621"));

			List<ATM> atmList = new ArrayList<ATM>();
			
			ATM atm1 = new ATM(address1, 0, "ING");
			ATM atm2 = new ATM(address2, 0, "ING");
			
			atmList.add(atm1);
			atmList.add(atm2);
			
			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(atmList);
			
			System.out.println(jsonInString);
			
		} catch (IOException e) {
			
			log.debug(e.getMessage());
		
		} catch (Exception e) {
			
			log.debug(e.getMessage());
		}
	}
}