package br.com.brunoenofiti.app.data.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.city.model.City;

public class DataTest {

	private AtmDAO atmDAO;
	
	private AddressDAO addressDAO;
	
	private CityDAO cityDAO;

//	@Test
//	public void testJson(){
//		
//	}
	
	@Test
	public void testAtm(){
		
		atmDAO = new AtmDAO();
		
		List<ATM> atmList = atmDAO.getAtmFromDatabase();
		
		if(atmList == null ||  atmList.isEmpty()){
			fail();
		}
			
		for(ATM atm : atmList){
			if(atm.getAddress() == null 
					|| atm.getType() == null){
				
				fail();
			}
		}	
	}

	
	
	@Test
	public void testAddress(){
		
		addressDAO = new AddressDAO();
		
		List<Address> addressList = addressDAO.getAddressesFromDatabase();
		
		if(addressList == null ||  addressList.isEmpty()){
			fail();
		}
			
		for(Address a : addressList){
			if(a.getCity() == null 
					|| a.getGeoLocation() == null 
					|| a.getHousenumber() == null
					|| a.getPostalcode() == null
					|| a.getStreet() == null){
				
				fail();
			}
		}	
	}
	
	@Test
	public void testCity(){
		
		cityDAO = new CityDAO();
		
		List<City> cityList = cityDAO.getCitiesFromDatabase();
		
		if(cityList == null ||  cityList.isEmpty()){
			fail();
		}
			
		for(City c : cityList){
			if(c.getName() == null
					|| c.getCountry() == null
					|| c.getProvinces() == null){
				fail();
			}
		}
	}
	
}