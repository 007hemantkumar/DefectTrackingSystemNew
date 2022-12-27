package com.example.repository;

import java.util.Optional;

import com.example.model.TicketDefectMaster;
import com.example.model.UserMaster;

public interface LoginRepository {

	public UserMaster userLogin(UserMaster userMaster);
	
	public UserMaster userLogout(UserMaster userMaster);

	  int QACreateDefect(TicketDefectMaster ticketDefectMaster);


}
