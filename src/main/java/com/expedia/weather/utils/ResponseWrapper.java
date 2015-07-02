/**
 * 
 */
package com.expedia.weather.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @author Prem
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonRootName("response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWrapper {
	
	@JsonProperty("version")
    private String version;
	
	@JsonProperty("error")
	private ErrorWrapper error;

	
	
	@JsonProperty("current_observation")
	CurrentObservationWrapper currentObservationWrapper;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public CurrentObservationWrapper getCurrentObservationWrapper() {
		return currentObservationWrapper;
	}

	public void setCurrentObservationWrapper(
			CurrentObservationWrapper currentObservationWrapper) {
		this.currentObservationWrapper = currentObservationWrapper;
	}

	public ErrorWrapper getError() {
		return error;
	}

	public void setError(ErrorWrapper error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ResponseWrapper [version=" + version + ", error=" + error
				+ ", currentObservationWrapper=" + currentObservationWrapper
				+ "]";
	}
	
	
	
	
}
