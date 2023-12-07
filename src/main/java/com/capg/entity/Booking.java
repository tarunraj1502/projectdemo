package com.capg.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Booking {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="BookingId")
 private int bookingId;
 
 @Column(name="BookedDate")
 private LocalDate bookedDate;
 
 @Column(name="ShowDate")
 private LocalDate showDate;
 
 @Column(name="NoofSeats")
 private int noofSeats;
 
 @ManyToOne
 @JoinColumn(name="ShowId")
 private Shows shows;
 
 @ManyToOne
 @JoinColumn(name="UserId")
 private Users users;

	@OneToMany(mappedBy="bookings",cascade=CascadeType.ALL)
	private List<SeatType> seattype;
	
	
	
//	@ManyToOne
//	@JoinColumn(name="NoofSeats")
//	private int noofSeats;

public Booking(int bookingId, LocalDate bookedDate, LocalDate showDate,int noofSeats) {
	super();
	this.bookingId = bookingId;
	this.bookedDate = bookedDate;
	this.showDate = showDate;
	this.noofSeats=noofSeats;
}

public int getBookingId() {
	return bookingId;
}

public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}

public LocalDate getBookedDate() {
	return bookedDate;
}

public void setBookedDate(LocalDate bookedDate) {
	this.bookedDate = bookedDate;
}

public LocalDate getShowDate() {
	return showDate;
}

public void setShowDate(LocalDate showDate) {
	this.showDate = showDate;
}
public int getNoofSeats() {
	return noofSeats;
}

public void setNoofSeats(int noofSeats) {
	this.noofSeats = noofSeats;
}

@Override
public String toString() {
	return "Booking [bookingId=" + bookingId + ", bookedDate=" + bookedDate + ", showDate=" + showDate + ", noofSeats="
			+ noofSeats + ", shows=" + shows + ", users=" + users + ", seattype=" + seattype + "]";
}
}
