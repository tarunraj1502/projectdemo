package com.capg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.capg.entity.SeatType;
import com.capg.service.SeatTypeServiceImpl;

public class SeatTypeController {
	@Autowired
	SeatTypeServiceImpl seatTypeservice;
	  
	  @GetMapping("/seattype")
	  public ResponseEntity<List<SeatType>> getAllSeatType()
	  {
		  return new ResponseEntity<List<SeatType>>(seatTypeservice.getAllSeatType(),HttpStatus.OK);
	  }
	  
	  @PostMapping("/Addseattype")
	  public ResponseEntity<SeatType> addSeatType(@RequestBody SeatType seatType){
		  return new ResponseEntity<SeatType>(seatTypeservice.addSeatType(seatType),HttpStatus.OK);
	  }
	  @DeleteMapping("/seattype/{id}")
		public ResponseEntity<String> deleteSeatTypeById(@PathVariable int id)
		{
			return new ResponseEntity<String>(seatTypeservice.deleteSeatTypeById(id), HttpStatus.OK);
		}
}
