package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.TicketDefectMaster;
import com.example.model.UserMaster;
import com.example.repository.LoginRepository;

@Service
public class LoginService {
@Autowired
	private LoginRepository repo;

public UserMaster loginUser(UserMaster userMaster) {
	return repo.userLogin(userMaster);
}
public UserMaster logoutUser(UserMaster userMaster) {
	return repo.userLogout(userMaster);
	
}

public int QACreateDefect(TicketDefectMaster ticketDefectMaster) {
	return repo.QACreateDefect(ticketDefectMaster);
}
}
