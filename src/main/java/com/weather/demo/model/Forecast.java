package com.weather.demo.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/* 
 * Since the weather service includes a bunch of extra properties (UV index, 
 * cloud cover, dew point, etc), we want to ignore properties that aren't mapped
 * instead of throwing an exception
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
	private double latitude;
	private double longitude;
	private String timezone;
	private Hourly hourly;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Hourly getHourly() {
		return hourly;
	}

	public void setHourly(Hourly hourly) {
		this.hourly = hourly;
	}

	// Convenience for testing as a simple JSON service
	@Override
	public String toString() {
		return "Forecast [latitude=" + latitude + ", longitude=" + longitude + ", timezone=" + timezone + ", hourly="
				+ hourly + "]";
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Hourly {
	private String summary;
	private ArrayList<Data> data;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ArrayList<Data> getData() {
		return data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Hourly [summary=" + summary + ", data=" + data + "]";
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Data {
	@JsonProperty(value = "time")
	private long timestamp;
	private String summary;
	private double temperature;
	private double humidity;
	private double windSpeed;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	@Override
	public String toString() {
		return "Data [timestamp=" + timestamp + ", summary=" + summary + ", temperature=" + temperature + ", humidity="
				+ humidity + ", windSpeed=" + windSpeed + "]";
	}

}