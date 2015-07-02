/**
 * 
 */
package com.expedia.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.expedia.weather.dao.WeatherDao;
import com.expedia.weather.domain.City;
import com.expedia.weather.domain.Forecast;
import com.expedia.weather.domain.LocationForecast;
import com.expedia.weather.utils.ErrorUtils;
import com.expedia.weather.utils.ResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Prem
 * 
 */
@Service("wunderGroundServiceImpl")
public class WunderGroundServiceImpl implements WeatherService {

	@Autowired
	// @Qualifier("wunderGroundDaoImpl")
	WeatherDao weatherDao;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	LocationForecast locationForecast;

	private static final Logger logger = LoggerFactory
			.getLogger(WunderGroundServiceImpl.class);

	/**
	 * Uses JSON's objectMapper to map the response into fields in wrapper classes. 
	 * 
	 * @param response
	 * 
	 * 
	 */
	public void prepareResult(ResponseWrapper response) {

		City city;
		Forecast forecast;

		if (objectMapper != null) {
			city = objectMapper.convertValue(
					response.getCurrentObservationWrapper()
							.getDisplayLocationWrapper(), City.class);
			forecast = objectMapper.convertValue(
					response.getCurrentObservationWrapper(), Forecast.class);

			locationForecast.setCity(city);
			locationForecast.setForecast(forecast);
			logger.info(city.toString());
			logger.info(forecast.toString());
		} else
			logger.info("Check objectmapper wiring");
	}

	/*
	 * (non-Javadoc) Checks the responsenEntity for error returned, if
	 * responsenEntity contains weather errors or no weather observation details
	 * returns true to indicate error situtaion else returns true
	 * 
	 * @see
	 * com.expedia.weather.service.WeatherService#checkForErrors(org.springframework
	 * .http.ResponseEntity)
	 */
	@Override
	public boolean checkForErrors(ResponseEntity<ResponseWrapper> response) {
		if (response == null)
			return true;
		else {
			if (ErrorUtils.checkForErrors(response.getStatusCode()))
				return true;

			if (response.getBody().getCurrentObservationWrapper() == null)
				return true;

			logger.info(response.getStatusCode().series() + "No errors found");
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * Initiates the DAO to make the rest call to fetch weather details, 
	 * @return response that is wrapped in LocationForecast to suit the JSP page.
	 * 
	 * @see com.expedia.weather.service.WeatherService#fectchData(int)
	 */
	@Override
	public LocationForecast fectchWeatherInfo(String zip) {

		logger.info("Fetch Weather info for " + zip);

		ResponseEntity<ResponseWrapper> response = (ResponseEntity<ResponseWrapper>) weatherDao
				.accessRestJSON(zip);
		logger.info(response.toString());

		if (!checkForErrors(response)) {
			System.out.println(response.toString());
			ResponseWrapper result = response.getBody();
			prepareResult(result);
		} else
			return null;

		return locationForecast;
	}

}
