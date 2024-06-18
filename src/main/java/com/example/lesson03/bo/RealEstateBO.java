package com.example.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.RealEstate;
import com.example.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper; 
	
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateByRentPrice(int rentprice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentprice);
	}
	
	public List<RealEstate> getRealEstateByAreaAndPrice(int area, int price) {
		return realEstateMapper.selectRealEstateByAreaAndPrice(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	public int addRealEstateAsField(
			int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstateByIdPriceType(int id, int price, String type) {
		return realEstateMapper.updateRealEstateByIdPriceType(id, price, type);
	}
	
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
}
