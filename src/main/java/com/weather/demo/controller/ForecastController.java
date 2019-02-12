package com.weather.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weather.demo.model.Forecast;
import com.weather.demo.service.ForecastService;

/*
 * Specifically used for Spring MVC controllers, use @RestController if you want
 * a simple JSON request/response service
 */
@Controller
public class ForecastController {

	@Autowired
	private ForecastService forecastService;

	
	// Equivalent to @RequestMapping(method = RequestMethod.GET) 
	@GetMapping("/forecast")
	public String getForecast(@RequestParam(value = "latitude", defaultValue = "39.1031") String latitude,
			@RequestParam(value = "longitude", defaultValue = "-84.5120") String longitude, Model model) {
		Forecast forecast = forecastService.getWeatherForecast(latitude, longitude);
		
		// Set the forecast object to be passed over to the Thymeleaf templating engine
		model.addAttribute("forecast", forecast);
		
		// Route the user to forecast.html, under the src/main/resources/templates folder
		return "forecast";
	}
}
