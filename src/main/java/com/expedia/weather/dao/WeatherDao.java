/**
 * 
 */
package com.expedia.weather.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


/**
 * @author Prem
 *
 */
@Component
public interface WeatherDao {
	public ResponseEntity accessRestJSON(String zip);
}
