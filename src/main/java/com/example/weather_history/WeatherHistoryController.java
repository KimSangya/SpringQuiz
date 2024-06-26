package com.example.weather_history;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.weather_history.bo.WeatherHistoryBO;
import com.example.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	@GetMapping("/weather-list-view")
	public String weatherList(Model model) {
		List<WeatherHistory> weatherHistorys = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistory", weatherHistorys);
		return "weather_history/weatherList";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeather() {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add-weather")
	public String addNewWeather(
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed
			,Model model) {
		weatherHistoryBO.addNewWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		return "redirect:/weather-history/weather-list-view";
	}
}
