package com.example.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson07.Entity.CompanyEntity;
import com.example.lesson07.Repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// input : 4개의 파라미터
	// output : CompanyEntity를 리턴
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		CompanyEntity company = CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		return companyRepository.save(company);
	}
}
