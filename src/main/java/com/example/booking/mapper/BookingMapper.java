package com.example.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.booking.domain.Booking;

@Mapper
public interface BookingMapper {
	
	public List<Booking> bookingList();
	
	// input: id
	// output : int
	public int deleteBookingById(int id);
	
	public void insertBooking(
			@Param("name") String name, 
			@Param("date") LocalDate date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public List<Booking> checkBookingByNameAndPhone(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}
