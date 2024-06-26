package com.example.weather_history.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weather_history.domain.WeatherHistory;
import com.example.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	public void addNewWeather(String date, String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		weatherHistoryMapper.insertNewWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
