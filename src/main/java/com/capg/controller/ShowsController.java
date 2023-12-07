package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.ShowDto;

import com.capg.entity.Shows;

import com.capg.service.ShowsService;
@RestController
@RequestMapping("/api/v1")
public class ShowsController {

	
	@Autowired
	private ShowsService showsService;
	@GetMapping("/listAllShows")
	public ResponseEntity<List<Shows>> getListOfShows()
	{
		return new ResponseEntity<List<Shows>> (showsService.getListOfShows(),HttpStatus.OK);
	}
	@PostMapping("/addShows")
	public ResponseEntity<Shows> addShows(@RequestBody Shows show)
	{
		return new ResponseEntity<Shows>(showsService.addShows(show),HttpStatus.OK);
	}
	@DeleteMapping("/shows/{id}")
	public ResponseEntity<String> deleteShowsById(@PathVariable int id)
	{
		return new ResponseEntity<String>(showsService.deleteShowsById(id), HttpStatus.OK);
	}
  
  @PutMapping("/shows/{id}")
	public ResponseEntity<Shows> updateShowsById(@PathVariable int id,@RequestBody Shows shows)
	{
		return new ResponseEntity<Shows>(showsService.updateShowById(id, shows), HttpStatus.OK);
	}
  @GetMapping("/show/{id}")
	public ResponseEntity<Shows> getShowById(@PathVariable int id)
	{
		return new ResponseEntity<Shows>(showsService.getShowById(id), HttpStatus.OK);
	}
  @PostMapping("/addShows2")
	public ResponseEntity<Shows> addShows(@RequestBody ShowDto showDto)
	{
		return new ResponseEntity<Shows>(showsService.addShows2(showDto),HttpStatus.OK);
	}
}
