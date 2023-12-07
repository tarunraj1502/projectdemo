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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.entity.Users;
import com.capg.service.UsersServiceImpl;
@RequestMapping("/api/v1")
@RestController
public class UsersController {

	@Autowired
	  UsersServiceImpl usersService;
	  
	  @GetMapping("/users")
	  public ResponseEntity<List<Users>> getAllUsers()
	  {
		  return new ResponseEntity<List<Users>>(usersService.getAllUsers(),HttpStatus.OK);
	  }
	  
	  @PostMapping("/Addusers")
	  public ResponseEntity<Users> addUsers(@RequestBody Users users){
		  return new ResponseEntity<Users>(usersService.addUsers(users),HttpStatus.OK);
	  }
	  @DeleteMapping("/users/{id}")
		public ResponseEntity<String> deleteUsersById(@PathVariable int id)
		{
			return new ResponseEntity<String>(usersService.deleteUsersById(id), HttpStatus.OK);
		}
}
