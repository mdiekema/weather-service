package com.weather.demo.service;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.demo.model.Forecast;

@Service
public class ForecastService {
	
	/*
	 *  Reads in the forecast.secretKey property from application.properites.
	 *  You can also provide an application.yml file for yaml configuration.
	 */
	@Value("${forecast.secretKey}")
	private String secretKey;
	
	@Value("${forecast.base.url}")
	private String darkSkyBaseUrl;
	
	public Forecast getWeatherForecast(String latitude, String longitude) {
		String urlString = darkSkyBaseUrl + "/" + secretKey + "/" + latitude + "," + longitude;
		ObjectMapper mapper = new ObjectMapper();
		Forecast forecast = new Forecast();
        try {
        	// Calls the weather service at the specified URL and converts the 
        	// JSON response to a forecast object
            forecast = mapper.readValue(new URL(urlString), new TypeReference<Forecast>(){});
        } catch (IOException ex) {
        	System.out.println("An unexpected error occurred while fetching the weather forecast - " + ex);
            ex.printStackTrace();
        }
        return forecast;
	}
}
