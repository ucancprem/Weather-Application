/**
 * 
 */
package com.expedia.weather.utils;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;



/**
 * @author Prem
 *
 */
public class ErrorHandler implements ResponseErrorHandler	{

	private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
	

	
	/* (non-Javadoc)
	 * @see org.springframework.web.client.ResponseErrorHandler#hasError(org.springframework.http.client.ClientHttpResponse)
	 */
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return ErrorUtils.checkForErrors(response.getStatusCode());
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.client.ResponseErrorHandler#handleError(org.springframework.http.client.ClientHttpResponse)
	 */
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		
		logger.error("Error response ",response.getStatusCode(),response.getStatusText());
	}
	

}
