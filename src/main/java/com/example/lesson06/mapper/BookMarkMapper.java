package com.example.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson06.domain.BookMark;

@Mapper
public interface BookMarkMapper {
	public List<BookMark> selectBookmarkList();
	public void insertBookMark(
			@Param("name") String name, 
			@Param("url") String url);
	
	// input : BO가 데이터가 있냐? -> 모든걸 다 줘
	// output : List<BookMark>
	// 결과를 확인을 해보는것이다. url의 내용이 저 내용을 가져 올 수 있는지?
	public List<BookMark> selectBookmarkListByUrl(String url); // url에 해당하는 친구들을 가져올수있고, url하나만 체크하는 식으로 확인할수있다.
	
	public int deleteBookmarkById(int id);
}
