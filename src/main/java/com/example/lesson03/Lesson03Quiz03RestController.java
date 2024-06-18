package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.RealEstateBO;
import com.example.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz03")
@RestController
public class Lesson03Quiz03RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	//http://localhost:8080/lesson03/quiz03/1?id=8&price=70000&type="전세"
	@RequestMapping("/1")
	public String quiz01(
			@RequestParam("id") int id,
			@RequestParam("price") int price,
			@RequestParam("type") String type){
		int rowCount = realEstateBO.updateRealEstateByIdPriceType(id, price, type);
		return "수정 성공 : " + rowCount;
	}
	
}
