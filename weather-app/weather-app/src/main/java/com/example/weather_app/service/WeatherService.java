package com.example.weather_app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weather_app.model.WeatherModel;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherModel getWeatherData(String city) {
        
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, WeatherModel.class);
    }
}
