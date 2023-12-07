package com.capg.entity;

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
public class SeatType {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="SeatTypeId")
  private int seatTypeId;
  
  @Column(name="SeatTypeDesc")
  private String seatTypeDesc;
  
  @Column(name="SeatFare")
  private float seatFare;
  
  
  @ManyToOne
  @JoinColumn(name="BookindId")
  private Booking bookings;
  
  @ManyToOne
  @JoinColumn(name="HallId")
  private Hall halls;

public SeatType(int seatTypeId, String seatTypeDesc, float seatFare) {
	super();
	this.seatTypeId = seatTypeId;
	this.seatTypeDesc = seatTypeDesc;
	this.seatFare = seatFare;
}

public int getSeatTypeId() {
	return seatTypeId;
}

public void setSeatTypeId(int seatTypeId) {
	this.seatTypeId = seatTypeId;
}

public String getSeatTypeDesc() {
	return seatTypeDesc;
}

public void setSeatTypeDesc(String seatTypeDesc) {
	this.seatTypeDesc = seatTypeDesc;
}

public float getSeatFare() {
	return seatFare;
}

public void setSeatFare(float seatFare) {
	this.seatFare = seatFare;
}
  
  
  
}
