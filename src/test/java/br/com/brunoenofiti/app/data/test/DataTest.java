package br.com.brunoenofiti.app.data.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.brunoneofiti.app.atm.business.ATMBusiness;
import br.com.brunoneofiti.app.atm.dao.AddressDAO;
import br.com.brunoneofiti.app.atm.dao.AtmDAO;
import br.com.brunoneofiti.app.atm.model.ATM;
import br.com.brunoneofiti.app.atm.model.Address;
import br.com.brunoneofiti.app.city.dao.CityDAO;
import br.com.brunoneofiti.app.city.model.City;
import br.com.brunoneofiti.app.common.business.BusinessException;
import br.com.brunoneofiti.app.config.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SecurityConfig.class})
public class DataTest {

	private Log log = LogFactory.getLog(DataTest.class);
	
	@Test
	public void testJson(){
		
		ATMBusiness atmBusiness = new ATMBusiness();
		
		List<ATM>  atmList = atmBusiness.callJsonLocalFile();
		
		log.info("size:" + atmList.size());
	}

	
	@Test
	public void testAtm() throws BusinessException {
		
		AtmDAO atmDAO = new AtmDAO();
		
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
	public void testAddress() throws BusinessException {
		
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
	public void testCity() throws BusinessException{
		
		CityDAO cityDAO = new CityDAO();
		
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