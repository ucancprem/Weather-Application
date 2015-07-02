/**
 * 
 */
package com.expedia.weather.utils;

/**
 * @author Prem
 * 
 */
public enum APIFormat {

	json("JSON"), xml("XML");

	private final String format;

	private APIFormat(String format) {
		this.format = format;
	}

	private String getFormat() {
		return format;
	}

	public static APIFormat getFormat(String format) {
		APIFormat[] formats = APIFormat.values();
		for (APIFormat currentFormat : formats) {
			if (format.equals(currentFormat.getFormat()))
				return currentFormat;
		}
		return json; // default method;
	}
}
