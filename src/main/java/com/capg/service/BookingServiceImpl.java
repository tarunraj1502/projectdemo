package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Booking;
import com.capg.entity.Hall;
import com.capg.exception.HallIdNotFoundException;
import com.capg.repository.BookingRepository;
import com.capg.utility.AppConstant;
@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository; 
	public List<Booking> getAllBooking() 
	{
		return bookingRepository.findAll();
	}
	public Booking addBooking(Booking booking) {
		bookingRepository.save(booking);
		return booking;
	}
	@Override
	 public String deleteBookingById(int id) {
		 String msg;
			if(bookingRepository.existsById(id))
			
				bookingRepository.deleteById(id);
				msg="Booking successfully deleted";
			
//			else
//			{
//				throw new HallIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
//			}
			
			return msg;
		}
	 
	 @Override
		public Booking updateBooking(int id, Booking booking) {
			
		 Booking updatedBooking=null;
			
			if(bookingRepository.existsById(id))
			
			   updatedBooking =	bookingRepository.save(booking);
			 
//			else
//			{
//				throw new HallIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
//			}
			
			return updatedBooking;
		}
}
