package com.backbase.assignment.ingAtms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import com.backbase.assignment.mainPage.model.ATM;
import com.backbase.assignment.mainPage.model.Address;
import com.backbase.assignment.mainPage.model.Geolocation;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IngAtmsDAO {

	@Autowired
	Log log;
	
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