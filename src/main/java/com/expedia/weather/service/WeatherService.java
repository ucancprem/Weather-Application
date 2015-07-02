/**
 * 
 */
package com.expedia.weather.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expedia.weather.domain.LocationForecast;
import com.expedia.weather.utils.ResponseWrapper;

/**
 * @author Prem
 *
 */
@Service
public interface WeatherService {

	public LocationForecast fectchWeatherInfo(String zip);

	/**
	 * @param responseEntity
	 */
	public boolean checkForErrors(ResponseEntity<ResponseWrapper> responseEntity);
}
