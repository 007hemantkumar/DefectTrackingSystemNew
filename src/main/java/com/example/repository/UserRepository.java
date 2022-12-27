package com.example.repository;

import java.util.List;

import com.example.model.UserMaster;

public interface UserRepository {
	
	int save(UserMaster userMaster);

	  int update(UserMaster userMaster);

	  UserMaster findById(Long id);

	  int deleteById(Long id);

	  List<UserMaster> findAll();

	  List<UserMaster> findByUserRole(String userRole);

	  List<UserMaster> findByUserName(String userName);

	  int deleteAll();

 
	
 
}
