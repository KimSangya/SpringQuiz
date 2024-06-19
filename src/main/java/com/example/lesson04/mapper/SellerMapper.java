package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {
	
	public int insertSeller(
			@Param("nickname") String nickname, 
			@Param("url") String url,
			@Param("temperature") Double temperature);
	
	public Seller selectLatestSellerNull();
	
	public Seller selectLatestSeller(int id);
}
