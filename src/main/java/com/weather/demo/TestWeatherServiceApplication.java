package com.weather.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*
 * By default, this annotation tells Spring to scan all packages underneath the one
 * it's in (com.weather.demo) for beans, and to use auto configuration (meaning jars
 * on the classpath such as tomcat-embedded.jar or h2.jar don't need to be explicitly
 * configured, and Spring will intelligently guess what default configuration would
 * have been provided)
 */
@SpringBootApplication
public class TestWeatherServiceApplication {

	public static void main(String[] args) {
		// Most simple applications just call SpringApplication.run, but you can assign this to
		// and application context and check for things, such as whether a bean is loaded
		ApplicationContext context = SpringApplication.run(TestWeatherServiceApplication.class, args);
		if (context.containsBean("forecastService")) {
			System.out.println("Found forecast service bean");
		}
	}

}

