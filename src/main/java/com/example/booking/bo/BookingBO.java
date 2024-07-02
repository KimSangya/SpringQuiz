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
	
	// input : name, phoneNumber
	// output : Booking(최신) or null
	// bo에서 가공하는게 많다.
	public Booking getLatestBookingByNamephoneNumber(String name, String phoneNumber) { // null or 채워져있는 친구
		// 리스트가 비어 있을 때는 : [] 있을 때 : [booking1, booking2] 
		List<Booking> bookingList = bookingMapper.selectBookingListByNamephoneNumber(name, phoneNumber);
//		if(bookingList.isEmpty()) {
//			return null;
//		} else {
//			return bookingList.get(bookingList.size() - 1);	
//		}
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}
