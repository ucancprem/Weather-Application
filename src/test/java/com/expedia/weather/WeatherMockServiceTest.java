/**
 * 
 */
package com.expedia.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.expedia.weather.controller.WeatherDisplayController;




import com.expedia.weather.domain.City;
import com.expedia.weather.domain.Forecast;
import com.expedia.weather.domain.LocationForecast;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.expedia.weather.service.WeatherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@WebAppConfiguration
public class WeatherMockServiceTest {

    @Mock
    WeatherService weatherService;

    @InjectMocks
    WeatherDisplayController weatherDisplayController;

    private MockMvc mockMvc;
    
    
    
    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/view/");
        internalResourceViewResolver.setSuffix(".jsp");
       weatherDisplayController= new WeatherDisplayController();
        
        this.mockMvc = MockMvcBuilders.standaloneSetup(weatherDisplayController)
            .setViewResolvers(internalResourceViewResolver).build();
        


           //.setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }
    /**
     * Check Basic page rendering
     * @throws Exception
     */
    @Test
    public void checkForPageDisplay() throws Exception {
        this.mockMvc.perform(post("/display").header("host", "localhost:8080")).andExpect(status().isOk());
            
    }
    /**
     * Mock Form validation when entered empty String
     * @throws Exception
     */
    @Test
    public void testEmptyZip() throws Exception {
        this.mockMvc.perform(post("/display").param("zip", "")).
        andExpect(model()
        		.attributeHasFieldErrors("location", "zip"));
    }
    /**
     * Mock Form validation when zip is less than 5 characters long
     * @throws Exception
     */
    @Test
    public void testForErrorLessThanFiveDigits() throws Exception {
        this.mockMvc.perform(post("/display").param("zip", "00")).
        andExpect(model()
        		.attributeHasFieldErrors("location", "zip"));
    }
    /**
     * Mock Form validation when zip is more than 5 characters long
     * @throws Exception
     */
    @Test
    public void testForErrorMoreThanFiveDigits() throws Exception {
        this.mockMvc.perform(post("/display").param("zip", "0000000")).
        andExpect(model()
        		.attributeHasFieldErrors("location", "zip"));
    }
    
    /**
     * Mock Form with invalid ZIP and check for Error Message
     * @throws Exception
     */
    @Test
    public void testForErrorWithErrorMessage() throws Exception {
    	MvcResult result =this.mockMvc.perform(post("/display").param("zip", "000")).andDo(print()).andReturn();



		try {
			
			boolean flag=getReturnedDefaultErrorMessages(result,"Invalid Zip Code Format");
			assertTrue(flag);
		    	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    /**
     * Mock Form with valid 5-digit ZIP and check for errors
     * @throws Exception
     */
    @Test
    public void testForValidFiveDigitZip() throws Exception {
        this.mockMvc.perform(post("/display").param("zip", "07104")).
        andExpect(model().hasErrors());
    }
    
    /**
     * Mock Form with valid 9-digit ZIP and check for errors
     * @throws Exception
     */
    @Test
    public void testForValidNineDigitZip() throws Exception {
        this.mockMvc.perform(post("/display").param("zip", "02201-1020")).
        andExpect(model().hasErrors());
    }
    
   
    
    public boolean getReturnedDefaultErrorMessages(MvcResult result,String lookForString)
    {
    	
    	String content=null;
    	try {
    		if(result!=null)
    		{
    			
    			content = result.getModelAndView().toString();
    			if(content.contains(lookForString.trim()))
    			{
        			return true;
    			}

    		}
    			
		    	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }
    
    /**
     * Mock Form to test view name when an invalid zip is entered
     * @throws Exception
     */
    @Test
    public void testViewNameWithInValidZip()
    {
    	when(weatherService.fectchWeatherInfo("00000")).thenReturn(null);

        MvcResult result;
		try {
			result = mockMvc.perform(
			        post("/display").param("zip", "00000")).andExpect(status().isOk()).andExpect(model().hasErrors()).andDo(print()).andReturn();
			
			String viewName=result.getModelAndView().getViewName();
			assertEquals(viewName,"weatherinfo");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    /**
     * Mock Form to test view name when an valid zip is entered
     * @throws Exception
     */
    @Test
    public void testViewNameWithValidZip()
    {
    	when(weatherService.fectchWeatherInfo("07104")).thenReturn(new LocationForecast(new City(), new Forecast()));

        MvcResult result;
		try {
			result = mockMvc.perform(
			        post("/display").param("zip", "07104")).andExpect(status().isOk()).andExpect(model().hasNoErrors()).andDo(print()).andReturn();
			
			String viewName=result.getModelAndView().getViewName();
			assertEquals(viewName,"weatherinfo");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    /**
     * Mock Form to non-digit zip code entry
     * @throws Exception
     */
    @Test
    public void testForErrorCharacterAsZipInput() throws Exception {
        this.mockMvc.perform(post("/display").param("zip", "abc")).
        andExpect(model()
        		.attributeHasFieldErrors("location", "zip"));
    }

    @Before
    public void setup() {

        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(weatherDisplayController).build();

    }


    /**
     * Mock to check 5-digit zip code which is not present.
     * @throws Exception
     */
    @Test
    public void createOrUpdateSuccessful() throws Exception {

        when(weatherService.fectchWeatherInfo("00000")).thenReturn(null);

        MvcResult result =mockMvc.perform(
                post("/display").param("zip", "00000")).andExpect(status().isOk()).andExpect(model().hasErrors()).andDo(print()).andReturn();
        
        		try {
        			
        			boolean flag=getReturnedDefaultErrorMessages(result,"Zip Code Not Found!");
        			assertTrue(flag);
        		    	
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
    }
}