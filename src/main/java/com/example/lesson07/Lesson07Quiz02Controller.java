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
	
	@GetMapping("/1")
	public List<RecruitEntity> quiz01() {
		// return recruitRepository.findAll();
		return recruitRepository.findById(8);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> quiz02() {
		return recruitRepository.findById(8);
	}
}
