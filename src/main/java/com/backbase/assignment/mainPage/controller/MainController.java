package com.backbase.assignment.mainPage.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.backbase.assignment.mainPage.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class MainController {

	
	@RequestMapping(value = "/restricted**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "JavaApp Title");
		model.addObject("content", "See list.");
		model.setViewName("main");

		return model;
	}

	@RequestMapping(value = "/ws", method = RequestMethod.GET)
	public ModelAndView adminPage2() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "JavaApp Title");
		model.addObject("content", "See list.");
		model.setViewName("main");

		String url = "http://localhost:8080/javaapp/ws/dutchcities";
		url = "https://www.ing.nl/api/locator/atms";

		callRest(url);
		
		sendGet(url);
		
		return model;
	}

	
    @SuppressWarnings("unused")
	private void callRest(String url) {
    	
    	RestTemplate restTemplate = new RestTemplate();

    	try {

    		ObjectMapper mapper = new ObjectMapper();
    		
    		System.out.println("debug 0: ");
    		
    		 ObjectMapper ob = new ObjectMapper();
    		
    		HashMap<String,Object> result = ob.readValue(new URL(url), HashMap.class);
    		
    		StringHttpMessageConverter s = ob.readValue(new URL(url), StringHttpMessageConverter.class);
    		
    		//JSON from URL to Object
    		Address address =  mapper.readValue(new URL(url), Address.class);
    		
    		
            System.out.println(address.toString());
            
    	}catch (Exception e) {
			System.out.println("bad 0");
			e.printStackTrace();
		}
    		
    		
    	try {
    		
    		System.out.println("debug 1: ");

    		List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
    		
    		ResponseEntity<Address> responseEntity = restTemplate.getForEntity(url, Address.class);

    		Object obj = responseEntity.getBody();
    		
    		MediaType contentType = responseEntity.getHeaders().getContentType();
    		
    		HttpStatus statusCode = responseEntity.getStatusCode();
    		
            //    		Address address = restTemplate.getForObject("https://www.ing.nl/api/locator/atms", Address.class);
    		//List<City> cities = (List<City>) restTemplate.getForObject(url, City.class);
            System.out.println(obj.toString());
    		
    	}catch (Exception e) {
			System.out.println("bad 1");
			e.printStackTrace();
		}
    }
    

	private void sendGet(String url){

		final String USER_AGENT = "Apache-HttpClient/4.1.1";

		String retorno;
		
		try {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// o metodo padrao e GET
			con.setRequestMethod("GET");

			//Request Header
			con.setRequestProperty("User-Agent", USER_AGENT);
			
			int responseCode = con.getResponseCode();
			System.out.println("Enviando request 'GET' para a URL : " + url + "\n");
			System.out.println("Codigo da resposta: " + responseCode + "\n");

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
			
			retorno = response.toString();
			
			//print do retorno
			System.out.println(retorno);
			
		}catch (Exception e) {
			System.out.println("bad 2");
			e.printStackTrace();
		}
	}

    
}