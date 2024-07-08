package com.example.lesson07.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryConfigurationAware;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.Entity.CompanyEntity;
import com.example.lesson07.Entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	// public List<RecruitEntity> FindById(int id);
	// public List<RecruitEntity> findAll();
	
	// 1번
	public List<RecruitEntity> findById(int id);
	
	// 2번
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	// 3번
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	// 4번
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 5번
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6번
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	
	// 7번
	// native query (DB에 직접 SQL)
	@Query(value = "select * from `recruit` "
			+ "where `deadline` > :deadline "
			+ "and `salary` >= :salary "
			+ "and `type` = :type "
			+ "order by `salary` desc"
			, nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndSalaryAndType(
			@Param("deadline") String deadline,
			@Param("salary") int salary,
			@Param("type") String type); 
	
}
