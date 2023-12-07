package com.capg.service;

import java.util.List;


import com.capg.entity.Users;

public interface UsersService {

	Users addUsers(Users users);
	List<Users> getAllUsers();
	String deleteUsersById(int id);
}
