package com.example.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.booking.domain.Booking;
import com.example.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	//input : X
	//output : List
	public List<Booking> bookingList() {
		return bookingMapper.bookingList();
	}
	
	// input: id
	// output : int
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name, LocalDate date, 
			int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// @RequestParam("name") String name,
	// @RequestParam("phoneNumber") String phoneNumber
	
	public List<Booking> checkBookingByNameAndPhone(String name, String phoneNumber) {
		return bookingMapper.checkBookingByNameAndPhone(name, phoneNumber);
	}
}
