/**
 * 
 */
package com.expedia.weather.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;

/**
 * Error utitlity to check if there response status has CLIENT_ERROR/SERVER_ERROR
 * 
 * @author Prem
 * 
 */
public class ErrorUtils {
	public static boolean checkForErrors(HttpStatus status) {
		Series series = status.series();
		if (HttpStatus.Series.CLIENT_ERROR.equals(series)
				|| HttpStatus.Series.SERVER_ERROR.equals(series))
		return true;

		return false;
	}

}
