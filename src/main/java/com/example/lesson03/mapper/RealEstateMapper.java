package com.example.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	
	public RealEstate selectRealEstateById(int id);
	public List<RealEstate> selectRealEstateByRentPrice(int rentprice);
	
	// Mapper 인터페이스가 xml로 파라미터를 전송할때, 한개만 전송할수있다(여러개일때는 MAP 형태로 보내야함)
	// 어노테이션의 이름은 param이다. 이 어노테이션을 사용하면 파라미터를 하나의 맵으로 구성해준다.
	public List<RealEstate> selectRealEstateByAreaAndPrice(
			@Param("area") int area,
			@Param("price") int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice
			);
	public int updateRealEstateByIdPriceType(
			@Param("id") int id, 
			@Param("price") int price, 
			@Param("type") String type);
	
	public int deleteRealEstateById(
			@Param("id") int id);
}
