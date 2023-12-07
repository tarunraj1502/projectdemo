package com.capg.service;

import java.util.List;

import com.capg.entity.Booking;


public interface BookingService {

	Booking addBooking(Booking booking);
	List<Booking> getAllBooking();
	String deleteBookingById(int id);
	Booking updateBooking(int id, Booking booking);
}
