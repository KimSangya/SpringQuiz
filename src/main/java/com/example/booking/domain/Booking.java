package com.example.booking.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Booking {
	private int id;
	private String name;
	private int headcount;
	private int day;
	private LocalDate date;
	private String phoneNumber;
	private String state;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
