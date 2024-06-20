package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Realtor;
import com.example.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {

	@Autowired
	private RealtorMapper realtorMapper;
	
	public int addRealtor(Realtor realtor) {
		return realtorMapper.insertRealtor(realtor);
	}
	
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
}
