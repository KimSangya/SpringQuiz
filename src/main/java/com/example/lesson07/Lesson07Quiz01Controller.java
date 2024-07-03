package com.example.lesson07;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.Entity.CompanyEntity;
import com.example.lesson07.bo.CompanyBO;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01Controller {
	
	@Autowired
	private CompanyBO companyBO;
	
	// /lesson07/quiz01/save1
	@GetMapping("/save1")
	public CompanyEntity save1() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
//		CompanyEntity companyEntity = companyBO.addCompany(name, business, scale, headcount);
//		Map<String, Object> result = new LinkedHashMap<>(); 
//		result.put("회사명", companyEntity.getName());
//		result.put("사업내용", companyEntity.getBusiness());
//		result.put("대기업", companyEntity.getScale());
//		result.put("사원수", companyEntity.getHeadcount());
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
//		CompanyEntity companyEntity = companyBO.addCompany(name, business, scale, headcount);
//		Map<String, Object> result = new LinkedHashMap<>(); 
//		result.put("회사명", companyEntity.getName());
//		result.put("사업내용", companyEntity.getBusiness());
//		result.put("대기업", companyEntity.getScale());
//		result.put("사원수", companyEntity.getHeadcount());
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		// id는 8번 규모를 중소기업, 사원수를 34명
		return companyBO.updateCompanyByScaleHeadcount(8, "중소기업", 34);
	}
	
	@GetMapping("/delete")
	public String delete() {
		// 8번의 객체를 삭제할것임.
		companyBO.deleteCompanyById(8);
		
		return "삭제 성공!";
	}
	
}
