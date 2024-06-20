package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Realtor;

@Mapper
public interface RealtorMapper{
	public int insertRealtor(Realtor realtor);
	public Realtor selectRealtorById(int id);
}
