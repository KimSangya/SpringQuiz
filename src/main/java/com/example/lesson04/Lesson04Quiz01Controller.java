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
			@RequestParam(value = "url", required = false) String url,
			@RequestParam(value = "temperature", required = false) Double temperature
			){
		// DB 저장
		sellerBO.addSeller(nickname, url, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=3
	
		Seller seller = null;
	
	@GetMapping("/seller-info-view")
	public String latestSellerView(
				Model model,
				@RequestParam(value = "id", required = false) Integer id) {
		if(id == null) {
			seller = sellerBO.getLatestSellerNull();
		} 
		else {
			seller = sellerBO.getLatestSeller(id);
		}
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		return "lesson04/latestSeller";
		
	}
}
