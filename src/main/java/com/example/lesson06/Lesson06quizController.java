package com.example.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson06.bookmarkbo.BookMarkBO;
import com.example.lesson06.domain.BookMark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06quizController {
	
	@Autowired
	private BookMarkBO bookMarkBO;
	
	@GetMapping("/add-bookmark-view")
	public String BookMarkList() {
		return "lesson06/bookMarkAdd";
	}
	
	@GetMapping("/bookmark-list-view")
	public String addBookMarkListView(Model model) {
		// db select => List<Bookmark>
		List<BookMark> bookMarkList = bookMarkBO.getBookmarkList();
		
		// model 담기
		model.addAttribute("bookMarkList", bookMarkList);
		return "lesson06/bookMarkList";
	}
	
	//ajax가 하는 요청
	// 즐겨찾기 추가 로직
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookMark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// TODO db insert
		bookMarkBO.addBookMark(name, url);
		
		// 성공에 대한 JSON
		// {"code" : 200, "result" : "성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
		
	}
	
	// AJAX 요청 - URL 중복확인
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url
			) {
		// db select
		boolean isDuplication = bookMarkBO.isDuplicationUrl(url);
		// 응답 JSON
		// {"code": 200, "is-duplication" : true}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result;
		
	}
	//http:localhost:8080/lesson06/delete-bookmark?id=3
	// ajax 요청 - id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		// db delete
		int rowCount = bookMarkBO.deleteBookmarkById(id);
		
		// 응답값 json
		Map<String, Object> result = new HashMap<>();
		if(rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다."); 
		}
		return result;
	}
}
