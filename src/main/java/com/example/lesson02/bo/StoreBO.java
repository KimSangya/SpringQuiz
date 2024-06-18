package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.Store;
import com.example.lesson02.mapper.StoreMapper;

@Service
public class StoreBO {
	
	@Autowired
	private StoreMapper storeMapper;
	
	public List<Store> getStoreList(){
		return storeMapper.selectStoreList(); // 컨트롤러한테 전달
	}
}
