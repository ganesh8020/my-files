package com.example.weather_app.controller;



import com.example.weather_app.model.WeatherModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin("*")
public class WeatherController {

    @Autowired
    private com.example.weather_app.service.WeatherService service;

    @GetMapping
    public WeatherModel getWeather(@RequestParam String city) {
        return service.getWeatherData(city);
    }
}
