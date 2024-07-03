package com.example.lesson07.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "recruit")
@Getter
@Entity
public class RecruitEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "companyId")
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	private LocalDateTime deadline;
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
