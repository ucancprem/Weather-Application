/**
 * 
 */
package com.expedia.weather.domain;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Prem
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Forecast {
	
	String temp_c;
	String temp_f;
	String feelslike_c;
	String feelslike_f;
	String weather;
	String icon_url;
	String wind_mph;
	String wind_kph;
	String relative_humidity;
	
	
	public String getTemp_c() {
		return temp_c;
	}
	public void setTemp_c(String temp_c) {
		this.temp_c = temp_c;
	}
	public String getTemp_f() {
		return temp_f;
	}
	public void setTemp_f(String temp_f) {
		this.temp_f = temp_f;
	}
	public String getFeelslike_c() {
		return feelslike_c;
	}
	public void setFeelslike_c(String feelslike_c) {
		this.feelslike_c = feelslike_c;
	}
	public String getFeelslike_f() {
		return feelslike_f;
	}
	public void setFeelslike_f(String feelslike_f) {
		this.feelslike_f = feelslike_f;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	
	public String getWind_mph() {
		return wind_mph;
	}
	public void setWind_mph(String wind_mph) {
		this.wind_mph = wind_mph;
	}
	public String getWind_kph() {
		return wind_kph;
	}
	public void setWind_kph(String wind_kph) {
		this.wind_kph = wind_kph;
	}
	public String getRelative_humidity() {
		return relative_humidity;
	}
	public void setRelative_humidity(String relative_humidity) {
		this.relative_humidity = relative_humidity;
	}
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}
	@Override
	public String toString() {
		return "Forecast [temp_c=" + temp_c + ", temp_f=" + temp_f
				+ ", feelslike_c=" + feelslike_c + ", feelslike_f="
				+ feelslike_f + ", weather=" + weather + ", icon_url="
				+ icon_url + ", wind_mph=" + wind_mph + ", wind_kph="
				+ wind_kph + ", relative_humidity=" + relative_humidity + "]";
	}
	
	
	
}
