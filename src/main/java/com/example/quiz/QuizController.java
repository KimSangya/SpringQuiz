package com.example.quiz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller
public class QuizController {
	
	@ResponseBody
	@RequestMapping("/1")
	public String Quiz01() {
		
		return "<h1> 테스트 프로젝트 완성 </h1> "
				+ "<b>해당 프로젝트를 통해서 문제 풀이를 진행합니다.</b>";
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Object> Quiz02() {
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		return map;
	}
}
