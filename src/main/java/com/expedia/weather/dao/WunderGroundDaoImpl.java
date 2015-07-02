/**
 * 
 */
package com.expedia.weather.dao;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import com.expedia.weather.utils.APIFormat;
import com.expedia.weather.utils.ResponseWrapper;

/**
 * WunderGround Dao implementation that makes a REST call and returns the return
 * response Entity to the caller.
 * 
 * @author Prem
 * 
 */
@Component("wunderGroundDaoImpl")
public class WunderGroundDaoImpl implements WeatherDao {

	@Value("${wunderground.rest.api.service.key}")
	private String wunderGroundAPIKey;
	
	@Value("${wunderground.rest.api.service.hostname}")
	private String hostName;
	
	@Value("${wunderground.rest.api.service.format}")
	private String format;

	private static final Logger logger = LoggerFactory.getLogger(WunderGroundDaoImpl.class);
	
	RestTemplate restTemplate;

	public WunderGroundDaoImpl() {
	}

	/**
	 * @param restTemplate
	 * 
	 * 
	 */
	@Autowired
	public WunderGroundDaoImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private String getWunderGroundAPIKey() {
		return wunderGroundAPIKey;
	}
	
	private String getFormat() {
		return format;
	}
	
	private String getHostName() {
		return hostName;
	}

	private boolean checkString(String str) {
		if (str == null || str.trim().equals(""))
			return false;
		return true;
	}

	/**
	 * Method creates the URL to make the rest call to using hostname, API KEY and the user entered zip code.
	 * 
	 * @param hostname
	 * @param key
	 * @param zip
	 * @param format
	 * @return URL in String format
	 */
	private String createURL(String hostname, String key, String zip,
			String format) {
		if (checkString(hostname) && checkString(key) && checkString(format)) {

			
			StringBuilder urlString = new StringBuilder("http://");
			urlString.append(hostname);
			urlString.append("/api/");
			urlString.append(key);
			urlString.append("/conditions/q/");
			urlString.append(zip);
			urlString.append("." + format);

			return urlString.toString();
		} else
			return null;

	}

	/*
	 * (non-Javadoc) 
	 * 
	 * This methods makes the REST call to the host, returns the response entity object back to the service.
	 * 
	 * @see com.expedia.weather.dao.WeatherDao#fetchData()
	 */
	@Override
	@ResponseBody
	public ResponseEntity<ResponseWrapper> accessRestJSON(String zip) {
		String key = getWunderGroundAPIKey();
		String host = getHostName();
		String fmt = getFormat();
		fmt = APIFormat.getFormat(fmt).toString();
		
		String url = createURL(host, key, zip, fmt); 
		logger.info("URL "+url);

		ResponseEntity<ResponseWrapper> result = null;
		try {
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setAccept(Collections.singletonList(new MediaType(
					"application", fmt)));
			HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
			
			result = null;
			if (url != null) {
				logger.info("URL "+url);
				restTemplate = new RestTemplate();
				result = restTemplate.exchange(url, HttpMethod.GET,
						requestEntity, ResponseWrapper.class);

			}
			else
				logger.info("URL null");
		} catch (RestClientException e) {

			e.printStackTrace();
		}

		return result;
	}

}
