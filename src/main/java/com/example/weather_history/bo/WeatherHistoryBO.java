package com.example.weather_history.bo;

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
	
	public void addNewWeather(WeatherHistory weatherHistory) {
		weatherHistoryMapper.insertNewWeather(weatherHistory);
	}
}
