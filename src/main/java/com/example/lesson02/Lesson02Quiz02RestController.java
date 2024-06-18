package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.StoreBO;
import com.example.lesson02.domain.Store;

@RestController
public class Lesson02Quiz02RestController {

	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		List<Store> storeList = storeBO.getStoreList();
		return storeList;
	}
}
