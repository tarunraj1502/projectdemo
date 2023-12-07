package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hall;
import com.capg.exception.HallIdNotFoundException;
import com.capg.repository.HallRepository;
import com.capg.utility.AppConstant;


@Service
public class HallServiceImpl implements HallService{
 @Autowired
 HallRepository hallRepository;
 
 @Override
 public Hall addHall(Hall hall) {
	
	 return hallRepository.save(hall);
 }
 
 @Override
 public List<Hall> getAllHall(){
	 return hallRepository.findAll();
 }
 
 @Override
 public String deleteHallById(int id) {
	 String msg;
		if(hallRepository.existsById(id))
		{
			hallRepository.deleteById(id);
			msg="Hall successfully deleted";
		}
		else
		{
			throw new HallIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
		}
		
		return msg;
	}
 
 @Override
	public Hall updateHall(int id, Hall hall) {
		
	 Hall updatedHall=null;
		
		if(hallRepository.existsById(id))
		{
		   updatedHall =	hallRepository.save(hall);
		 }
		else
		{
			throw new HallIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
		}
		
		return updatedHall;
	}
 }

