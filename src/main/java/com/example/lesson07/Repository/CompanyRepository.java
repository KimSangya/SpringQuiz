package com.example.lesson07.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.Entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

}
