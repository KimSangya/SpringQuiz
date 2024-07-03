package com.example.lesson07.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryConfigurationAware;

import com.example.lesson07.Entity.CompanyEntity;
import com.example.lesson07.Entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	// public List<RecruitEntity> FindById(int id);
	// public List<RecruitEntity> findAll();
	
	public List<RecruitEntity> findById(int id);
	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeAndSalaryIsGreaterThan(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	
}
