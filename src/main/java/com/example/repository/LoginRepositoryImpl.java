package com.example.repository;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.TicketDefectMaster;
import com.example.model.UserMaster;
@Repository
public class LoginRepositoryImpl implements LoginRepository {
    @Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserMaster userLogin(UserMaster userMaster) {
		try {
		
		// TODO Auto-generated method stub
		UserMaster userMaster1=jdbcTemplate.queryForObject("SELECT * from userMaster WHERE userName=? and password=?", 
				BeanPropertyRowMapper.newInstance(UserMaster.class),userMaster.getUserName(),userMaster.getPassword());
						return userMaster1;
	}catch(Exception exception) {
		return null;
	}
		 
		
	}

	 

	@Override
	public int QACreateDefect(TicketDefectMaster ticketDefectMaster) {
		return jdbcTemplate.update("INSERT INTO ticketDefect(ticketId,summary,description,status,assignedTo,category,version,ticketLifeStatus) VALUES (?,?,?,?,?,?,?,?) ",
				new Object[] {ticketDefectMaster.getTicketId(),ticketDefectMaster.getSummary(),ticketDefectMaster.getDescription(),ticketDefectMaster.getStatus(),ticketDefectMaster.getAssignedTo(),ticketDefectMaster.getCategory(),ticketDefectMaster.getVersion(),ticketDefectMaster.getTicketLifeStatus()}) ;
	}



	@Override
	public UserMaster userLogout(UserMaster userMaster) {
		// TODO Auto-generated method stub
		return null	;
	}

	 
	 

}
