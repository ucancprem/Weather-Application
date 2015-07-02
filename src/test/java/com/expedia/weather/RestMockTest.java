/**
 * 
 */
package com.expedia.weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.expedia.weather.domain.City;
import com.expedia.weather.domain.Forecast;
import com.expedia.weather.domain.LocationForecast;
import com.expedia.weather.service.WeatherService;
import com.expedia.weather.utils.ResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import com.expedia.weather.controller.WeatherDisplayController;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;


/**
 * @author Prem
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@WebAppConfiguration
public class RestMockTest {

		@Autowired
    	WeatherDisplayController weatherDisplayController;
   
		@Autowired
	    WeatherService weatherService;
		
		@Autowired
		ObjectMapper objectMapper;
	  
		private MockRestServiceServer mockServer;

		private RestTemplate restTemplate;

		@Before
		public void setup() {
			System.out.println("in here");
			this.restTemplate = new RestTemplate();
			this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
		}
		
	
	/**
	 * Helper method in test , that mocks rest template call
	 * @param responseBody
	 * @return
	 */
	public ResponseEntity<ResponseWrapper> prepareReponseEntity(String responseBody) {
		this.mockServer
		.expect(requestTo("/display"))
		.andExpect(method(HttpMethod.GET))
		.andRespond(
				withSuccess(responseBody, MediaType.APPLICATION_JSON));
		
		ResponseEntity<ResponseWrapper> responseEntity=null;
		try {
			
			ResponseWrapper responseWrapper = restTemplate.getForObject(
					"/display", ResponseWrapper.class);
			
			responseEntity = new ResponseEntity<ResponseWrapper>(
					responseWrapper, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseEntity;
	}

	/**
	 * basic mock request validation
	 * @throws Exception
	 */
	@Test
	public void performRequestValidation() throws Exception {

		String responseBody = TestUtils.getValidResponse();

		try {
			@SuppressWarnings("unused")
			ResponseEntity<ResponseWrapper> responseEntity = prepareReponseEntity(responseBody);

			this.mockServer.verify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
		/**
		 * test mock rest remplate response(valid)
		 * 
		 * @throws Exception
		 */
		@Test
		public void testRestSuccessfulResponse() throws Exception {

			String responseBody = TestUtils.getValidResponse();
			
				try {
				
				
				ResponseEntity<ResponseWrapper> responseEntity= prepareReponseEntity(responseBody);
				
				boolean flag=weatherService.checkForErrors(responseEntity);
				assertFalse(flag);
			
				this.mockServer.verify();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}

		/**
		 * test weatherService to correctly check for error response
		 * @throws Exception
		 */
		@Test
		public void testRestErrorResponse() throws Exception {

			String responseBody = TestUtils.getErrorResultString();
		try {
				
				ResponseEntity<ResponseWrapper> responseEntity= prepareReponseEntity(responseBody);
				
				boolean flag=weatherService.checkForErrors(responseEntity);
				assertTrue(flag);
				this.mockServer.verify();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
		
		/**
		 * test weatherService to correctly check for error response
		 * @throws Exception 
		 */
		@Test
		public void testZipCodeNotFound() throws Exception {

			String responseBody = TestUtils.getErrorResultString();
			
			try {
				
				ResponseEntity<ResponseWrapper> responseEntity= prepareReponseEntity(responseBody);
				
				boolean flag=weatherService.checkForErrors(responseEntity);
				assertTrue(flag);
			
				this.mockServer.verify();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
		public LocationForecast mapWithObjectMapper(ResponseWrapper response)
		{
			City city=objectMapper.convertValue(response.getCurrentObservationWrapper().getDisplayLocationWrapper(), City.class);
			Forecast forecast=objectMapper.convertValue(response.getCurrentObservationWrapper(), Forecast.class);
			
			LocationForecast locationForecast=new LocationForecast(city, forecast);
			
			return locationForecast;
		}
		
		/**
		 * Test to check json to display object mapping
		 * @throws Exception
		 */
		@Test
		public void testSuccessResultMapping() throws Exception {

			String responseBody = TestUtils.getValidResponse();
			try {
				
				ResponseEntity<ResponseWrapper> responseEntity= prepareReponseEntity(responseBody);
				
				LocationForecast locationForecast=mapWithObjectMapper(responseEntity.getBody());
				
				/*Checking for fields visible to viewers*/
				assertEquals(locationForecast.getCity().getCity(),"Newark");
				assertEquals(locationForecast.getCity().getState(),"NJ");
				
				
				assertEquals(locationForecast.getForecast().getTemp_f(),"82.6");
				assertEquals(locationForecast.getForecast().getTemp_c(),"28.1");
				assertEquals(locationForecast.getForecast().getFeelslike_c(),"29");
				assertEquals(locationForecast.getForecast().getFeelslike_f(),"85");
				assertEquals(locationForecast.getForecast().getWeather(),"Partly Cloudy");
				
				this.mockServer.verify();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
}
