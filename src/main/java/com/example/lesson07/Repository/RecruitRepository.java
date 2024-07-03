package com.example.lesson07.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lesson07.Entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	// public List<RecruitEntity> FindById(int id);
	// public List<RecruitEntity> findAll();
	
	public List<RecruitEntity> findById(int id);
}
