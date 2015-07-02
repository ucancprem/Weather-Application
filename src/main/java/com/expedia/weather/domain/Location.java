/**
 * 
 */
package com.expedia.weather.domain;

import java.io.Serializable;

import javax.validation.constraints.Pattern;


/**
 * @author Prem
 *
 */
public class Location implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Pattern checks for valid 5 digit or (5-4) format zip code, returns "Invalid Zip Code Format", if zip code does not match.
	 * 
	 */
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$",message="Invalid Zip Code Format")
	private String zip="";
	
	
	public Location() {
	}

	/**
	 * @param zip
	 */
	public Location(String zip) {

		this.zip = zip;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	

}

