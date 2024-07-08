package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// /lesson07/quiz02/1
	@GetMapping("/1")
	public List<RecruitEntity> quiz01() {
		// Id : 8
		return recruitRepository.findById(8);
	}
	
	// /lesson07/quiz02/2
	@GetMapping("/2")
	public List<RecruitEntity> quiz02(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(companyId);
	}
	
	// /lesson07/quiz02/3
	@GetMapping("/3")
	public List<RecruitEntity> quiz03() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// /lesson07/quiz02/4
	@GetMapping("/4")
	public List<RecruitEntity> quiz04() {
		// 정규직이거나(또는) 연봉이 9000이상인 공고
		// 방향만 잡힌 부분 > : findByTypeOrSalaryGreaterThan
		// 
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	// /lesson07/quiz02/5
	@GetMapping("/5")
	public List<RecruitEntity> quiz05() {
		// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 나열하기
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("정규직");
	}
	
	// /lesson07/quiz02/6
	@GetMapping("/6")
	public List<RecruitEntity> quiz06() {
		// 성남시 분당구가 지역이 연봉 7000 이상 8500 이하인 공고를 조회
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	public List<RecruitEntity> quiz07() {
		return recruitRepository.findByDeadlineAndSalaryAndType("2024-06-10", 8100, "정규직");
	}
}
