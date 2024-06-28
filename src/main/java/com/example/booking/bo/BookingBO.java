package com.example.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
