package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Seller;
import com.example.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	public void addSeller(String nickname, String url,
			Double temperature) {
		sellerMapper.insertSeller(nickname, url, temperature);
	}
	
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
}
