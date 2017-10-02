package com.backbase.assignment.data.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.backbase.assignment.dutchCities.dao.CityDAO;
import com.backbase.assignment.dutchCities.model.City;
import com.backbase.assignment.ingAtms.dao.IngAtmsDAO;
import com.backbase.assignment.mainPage.dao.AddressDAO;
import com.backbase.assignment.mainPage.model.Address;

public class DataTest {

			
	@Test
	public void testJson(){
		
		IngAtmsDAO a = new IngAtmsDAO();
		
		a.create();
	}
	
	@Test
	public void testAddress(){
		
		AddressDAO addressDAO = new AddressDAO();
		
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
		
		CityDAO cityDAO = new CityDAO();

		List<City> cityList = cityDAO.getCities();
		
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