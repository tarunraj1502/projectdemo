package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.entity.Users;
import com.capg.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	 UsersRepository usersRepository;
	 
	 @Override
	 public Users addUsers(Users users) {
		
		 return usersRepository.save(users);
	 }
	 
	 @Override
	 public List<Users> getAllUsers(){
		 return usersRepository.findAll();
	 }
	 
	 @Override
	 public String deleteUsersById(int id) {
		 String msg;
			if(usersRepository.existsById(id))
			
				usersRepository.deleteById(id);
				msg="Hall successfully deleted";
			
//			else
//			{
//				throw new HallIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
//			}
		
			return msg;
		}
}
