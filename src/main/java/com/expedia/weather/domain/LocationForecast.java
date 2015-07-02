
/**
 * 
 */
package com.expedia.weather.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * Wrapper class containing Final response shown on JSP.
 * @author Prem
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class LocationForecast {
	
	@Autowired
	private City city;
	@Autowired
	private Forecast forecast;
	
	
	
	/**
	 * @param city
	 * @param forecast
	 */
	@Autowired
	public LocationForecast(City city, Forecast forecast) {
		super();
		this.city = city;
		this.forecast = forecast;
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Forecast getForecast() {
		return forecast;
	}
	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	@Override
	public String toString() {
		return "LocationForecast [city=" + city + ", forecast=" + forecast
				+ "]";
	}
	
	

}
