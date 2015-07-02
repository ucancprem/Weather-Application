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
public class City {
	
	String zip;
	String city;
	String State;
	String country;
	
	
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "City [zip=" + zip + ", city=" + city + ", State=" + State
				+ ", country=" + country + "]";
	}
	
	
}
