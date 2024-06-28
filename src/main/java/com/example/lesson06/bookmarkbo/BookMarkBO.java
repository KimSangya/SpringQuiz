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
	
	// input : url
	// output : boolean
	public boolean isDuplicationUrl(String url) {
		 // 중복 [bookmark1, bookmark2] true / 중복 아닌 : [] false
		List<BookMark> bookmarkList = bookMarkMapper.selectBookmarkListByUrl(url);
		return bookmarkList.isEmpty() ? false : true;
		// return !bookmarkList.isEmpty(); -> true false로 나올수있다.
	}
	
	public int deleteBookmarkById(int id) {
		return bookMarkMapper.deleteBookmarkById(id);
	}
}
