package com.expedia.weather.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expedia.weather.domain.Location;
import com.expedia.weather.domain.LocationForecast;
import com.expedia.weather.service.WeatherService;

/**
 * Handles user requests and redirects them views with appropriate message.
 * 
 * @author Prem
 *
 */
@Controller
public class WeatherDisplayController {

	@Autowired
	WeatherService weatherService;

	private static final Logger logger = LoggerFactory
			.getLogger(WeatherDisplayController.class);

	/**
	 * Initial GET request, displaying the home screen
	 *
	 * @param location
	 * @param bindingResult
	 * @return String containing the name of the view/jsp page
	 */
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String displayHomePage(
			@ModelAttribute("location") Location location,
			BindingResult bindingResult) {
		logger.info("");
		if (bindingResult.hasErrors()) {
			logger.info("BindingResult has errors ");
		}

		return "weatherinfo";
	}

	
	
	/**
	 * Method handles POST request containing ZIP code to fetch weather details for.
	 * 
	 * @param location
	 * @param bindingResult
	 * @param model
	 * @return String containing the name of the view/jsp page, along with model information to populate the JSP page
	 */
	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public String fetchWeatherDetails(@ModelAttribute @Valid Location location,
			BindingResult bindingResult, Model model) {
		
		logger.info("in fetchWeatherDatils");
		
		if (bindingResult.hasErrors()) {
			logger.info("Error in Zip Code entered ");
		} else {
			LocationForecast locationForecast = weatherService
					.fectchWeatherInfo(location.getZip());

			if (locationForecast == null)
				bindingResult.rejectValue("zip", "errors","Zip Code Not Found!");

			model.addAttribute("locationForecast", locationForecast);

		}

		return "weatherinfo";
	}
	
	@ExceptionHandler({Exception.class})
	public String handleException()
	{
		return "weatherinfo";
	}

}
