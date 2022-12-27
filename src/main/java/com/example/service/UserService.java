package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserMaster;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
@Autowired
	private UserRepository repository;
  

public int save(UserMaster userMaster) {
	return repository.save(userMaster);
}

//Update
public int update(UserMaster userMaster) {
	return repository.update(userMaster);
}


public UserMaster findById(Long id) {
	return repository.findById(id);
	
}
public List<UserMaster> findAll(){
	return repository.findAll();
}

public int deleteUserById(Long id) {
	return repository.deleteById(id);
}

public List<UserMaster> findByRoleOfUser(String userRole){
	return repository.findByUserRole(userRole);
}

public List<UserMaster> FindByName(String userName){
	return repository.findByUserName(userName);
}
}
