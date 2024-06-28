package com.example.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.booking.domain.Booking;

@Mapper
public interface BookingMapper {
	
	public List<Booking> bookingList() ;
}
