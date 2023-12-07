package com.capg.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Hall {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="HallId")
  private int hallId;
  
  @Column(name="HallDesc")
  private String hallDesc;
  
  @Column(name="TotalCapacity")
  private int totalCapacity;
  

  
//  @Column(name="SeatTypeId")
//  private int seatTypeId;
  
//  @Column(name="SeatCount")
//  private int seatCount;
  
  @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
  @JsonManagedReference(value="HallId")
  private List<Shows> shows;
  
  @OneToMany(mappedBy="halls",cascade=CascadeType.ALL)
  private List<SeatType> seatType;
  


public Hall() {
	super();
}



public Hall(String hallDesc, int totalCapacity) {

	this.hallDesc = hallDesc;
	this.totalCapacity = totalCapacity;
//	this.seatTypeId = seatTypeId;
//	this.seatCount = seatCount;
}



public int getHallId() {
	return hallId;
}



public void setHallId(int hallId) {
	this.hallId = hallId;
}



public String getHallDesc() {
	return hallDesc;
}



public void setHallDesc(String hallDesc) {
	this.hallDesc = hallDesc;
}



public List<SeatType> getSeatType() {
	return seatType;
}



public void setSeatType(List<SeatType> seatType) {
	this.seatType = seatType;
}



@Override
public String toString() {
	return "Hall [hallId=" + hallId + ", hallDesc=" + hallDesc + ", totalCapacity=" + totalCapacity + ", shows=" + shows
			+ ", seatType=" + seatType + "]";
}



  
  
}
