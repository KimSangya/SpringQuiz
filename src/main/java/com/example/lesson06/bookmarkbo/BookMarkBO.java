package com.example.lesson06.bookmarkbo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson06.domain.BookMark;
import com.example.lesson06.mapper.BookMarkMapper;


@Service
public class BookMarkBO {
	// input : X
	// output : List<BookMark>
	@Autowired
	private BookMarkMapper bookMarkMapper;

	public List<BookMark> getBookmarkList() {
		return bookMarkMapper.selectBookmarkList();
	}
	
	// input : name url
	// output : X
	public void addBookMark(String name, String url) {
		bookMarkMapper.insertBookMark(name, url);
	}
}
