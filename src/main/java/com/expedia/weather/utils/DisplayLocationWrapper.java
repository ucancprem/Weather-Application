/**
 * 
 */
package com.expedia.weather.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Prem
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayLocationWrapper {

	@JsonProperty("full")
	private String cityAndState;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("state_name")
	private String stateName;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("country_iso3166")
	private String countryIso;
	
	@JsonProperty("zip")
	private String zip;
	
	@JsonProperty("latitude")
	private String latitude;
	
	@JsonProperty("longitude")
	private String longitude;
	
	@JsonProperty("elevation")
	private String elevation;

	public String getCityAndState() {
		return cityAndState;
	}

	public void setCityAndState(String cityAndState) {
		this.cityAndState = cityAndState;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryIso() {
		return countryIso;
	}

	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DisplayLocationWrapper [cityAndState=" + cityAndState
				+ ", city=" + city + ", state=" + state + ", stateName="
				+ stateName + ", country=" + country + ", countryIso="
				+ countryIso + ", zip=" + zip + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", elevation=" + elevation + "]";
	}
		
	

}
