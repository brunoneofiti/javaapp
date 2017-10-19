package com.backbase.assignment.data.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.backbase.assignment.data.dao.TestsAtmsDAO;

import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.city.model.City;

public class DataTest {

			
	@Test
	public void testJson(){
		
		TestsAtmsDAO dao = new TestsAtmsDAO();
		
		dao.create();
	}
	
	@Test
	public void testAddress(){
		
		AddressDAO dao = new AddressDAO();
		
		List<Address> addressList = dao.getAddressesFromDatabase();
		
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
		
		CityDAO dao = new CityDAO();

		List<City> cityList = dao.getCities();
		
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