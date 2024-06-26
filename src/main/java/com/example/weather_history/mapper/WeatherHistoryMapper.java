package com.example.weather_history.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	public List<WeatherHistory> selectWeatherHistoryList();
	public int insertNewWeather(
			@Param("date") String date, 
			@Param("weather") String weather, 
			@Param("temperatures") double temperatures, 
			@Param("precipitation") double precipitation, 
			@Param("microDust") String microDust, 
			@Param("windSpeed") double windSpeed);
}
