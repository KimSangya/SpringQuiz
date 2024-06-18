package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.SellerBO;
import com.example.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	@RequestMapping(path = "/add-seller-view", method=RequestMethod.GET)
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("url") String url,
			@RequestParam("temperature") Double temperature
			){
		// DB 저장
		sellerBO.addSeller(nickname, url, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String latestSellerView(Model model) {
		Seller seller = sellerBO.getLatestSeller();
		
		model.addAttribute("result", seller);
		
		return "lesson04/latestSeller";
		
	}
}
