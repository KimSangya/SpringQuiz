package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.RealEstateBO;

@RequestMapping("/lesson03/quiz04")
@RestController
public class Lesson03Quiz04RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	//http://localhost:8080/lesson03/quiz04/1?id=21
	@RequestMapping("/1")
	public String quiz04(
			@RequestParam("id") int id) {
		int numCount = realEstateBO.deleteRealEstateById(id);
		return "삭제 성공! : " + numCount;
	}
}
