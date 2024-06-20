package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.RealtorBO;
import com.example.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02controller {
	
	@Autowired
	private RealtorBO realtorBO;
	
	// http://localhost:8080/lesson04/quiz02/addRealtor
	@GetMapping("/addRealtor")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		// DB Insert를 하는게 첫번째
		realtorBO.addRealtor(realtor);
		
		int id = realtor.getId();
		Realtor latestRealtor = realtorBO.getRealtorById(id);
		
		model.addAttribute("realtor", latestRealtor);
		
		return "lesson04/afterAddRealtor";
	}
}
