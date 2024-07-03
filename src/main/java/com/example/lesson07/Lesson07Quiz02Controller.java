package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.Entity.CompanyEntity;
import com.example.lesson07.Entity.RecruitEntity;
import com.example.lesson07.Repository.CompanyRepository;
import com.example.lesson07.Repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02Controller {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/1")
	public List<RecruitEntity> quiz01() {
		// return recruitRepository.findAll();
		return recruitRepository.findById(8);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> quiz02() {
		return recruitRepository.findByCompanyId(1);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> quiz03() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> quiz04() {
		return recruitRepository.findByTypeOrSalaryGreaterThan("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> quiz05() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("정규직");
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> quiz06() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
}
