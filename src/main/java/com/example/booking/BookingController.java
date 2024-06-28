package com.example.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.booking.bo.BookingBO;
import com.example.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;

	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		List<Booking> booking = bookingBO.bookingList();
		model.addAttribute("booking", booking);
		return "/booking/bookingList";
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "/booking/makeBooking";
	}
	
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "/booking/checkBooking";
	}
	
	
	
}
