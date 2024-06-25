package com.example.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	public List<WeatherHistory> selectWeatherHistoryList();
	public void insertNewWeather(WeatherHistory weatherHistory);
}
