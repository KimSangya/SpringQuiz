package com.example.lesson07.bo;

import java.util.Optional;

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
		return companyRepository.save(CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	// input : 3개의 파라미터 id, scale, headcount
	// output : CompanyEntity를 리턴
	public CompanyEntity updateCompanyByScaleHeadcount(int id, String scale, int headcount) {
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		if(company != null) {
			company = companyRepository.save(company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build());
		}
		
		return company;
	}
	
	// input : 1개의 파라미터 id
	// output : X
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
}
