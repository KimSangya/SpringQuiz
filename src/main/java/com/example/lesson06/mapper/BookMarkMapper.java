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
}
