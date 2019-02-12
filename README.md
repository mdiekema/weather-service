This is a simple SpringBoot application that calls a weather service (https://darksky.net) and renders the 48 hour forecast in an HTML table. To test this, you will need to register for an account at (https://darksky.net) and update the forecast.secretKey property in application.properties to use your secret key. Then, run the application as a Spring Boot Application, and connect to http://localhost:8090/forecast to see the weather forecast data (defaults to Cincinnati, but you can change the latitude and longitude request parameters to get the weather for other cities) 