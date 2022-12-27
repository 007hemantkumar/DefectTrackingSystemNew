package com.example.repository;


import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.model.AdminTicketResponse;
import com.example.model.TicketDefectMaster;
import com.example.model.UserMaster;
@Repository
public class TicketDefectMasterImpl implements TicketDefectMasterRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(TicketDefectMaster ticketDefectMaster) {
			return jdbcTemplate.update("INSERT INTO ticketDefect(summary,description,status,assignedTo,category,version) VALUES (?,?,?,?,?,?) ",
				new Object[] {ticketDefectMaster.getSummary(),ticketDefectMaster.getDescription(),"open",ticketDefectMaster.getAssignedTo(),ticketDefectMaster.getCategory(),"0"}) ;
		}

	@Override
	public long updateByDev(TicketDefectMaster TicketDefectMaster) {
			return jdbcTemplate.update("UPDATE ticketDefect SET status=? where ticketId=?", 
				new Object[] {TicketDefectMaster.getStatus(),TicketDefectMaster.getTicketId()}) ;
		}
	@Override
	public long updateByQA(TicketDefectMaster ticketDefectMaster) {
		// TODO Auto-generated method stub
		
		
		
		if(ticketDefectMaster.getStatus().equalsIgnoreCase("reopen")){
	TicketDefectMaster tm=getTicketById(ticketDefectMaster.getTicketId()); 
	String INSERT_SQL 
	  = "INSERT INTO ticketDefect(summary,description,status,assignedTo,category,version) VALUES (?,?,?,?,?,?)";
	
	KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection
          .prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
          ps.setString(1, tm.getSummary());
          ps.setString(2, tm.getDescription());
          ps.setString(3, "Open");
          ps.setString(4, tm.getAssignedTo());
          ps.setString(5, tm.getCategory());
          ps.setLong(6, (tm.getVersion()+1));
         
          return ps;
        }, keyHolder);

        
 
		 jdbcTemplate.update("UPDATE ticketDefect SET status=?,ticketLifeStatus=? where ticketId=?", 
				new Object[] {"close",keyHolder.getKey().toString(),ticketDefectMaster.getTicketId()}) ;
		return ((BigInteger) keyHolder.getKey()).longValue();
		}
		else if(ticketDefectMaster.getAssignedTo()!=null || ticketDefectMaster.getStatus().equalsIgnoreCase("open")) {
			return jdbcTemplate.update("UPDATE ticketDefect SET  assignedTo=? where ticketId=?", 
					new Object[] {ticketDefectMaster.getAssignedTo(),ticketDefectMaster.getTicketId()}) ;
		}else
		{
			return jdbcTemplate.update("UPDATE ticketDefect SET status=? where ticketId=?", 
					new Object[] {ticketDefectMaster.getStatus(),ticketDefectMaster.getTicketId()}) ;
		}
		 
	}

	
	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM ticketDefect WHERE ticketId=?",id);
	}

	@Override
	public List<AdminTicketResponse> showAll() {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.query("SELECT t.`ticketId`, u.`userName` as AssignedTo, t.`summary`, t.`description`, t.`status`, t.`category`, t.`version`, t.`ticketLifeStatus` FROM demo.ticketdefect t inner join demo.usermaster u on u.id=t.assignedTo", BeanPropertyRowMapper.newInstance(AdminTicketResponse.class));
	}

	@Override
	public TicketDefectMaster getTicketById(Long id) {
		// TODO Auto-generated method stub
		return  jdbcTemplate.queryForObject("SELECT * FROM ticketDefect WHERE ticketId=? ", BeanPropertyRowMapper.newInstance(TicketDefectMaster.class),id);
	}

	@Override
	public List<TicketDefectMaster> showToQA(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT t.`ticketId`, u.`userName` as AssignedTo, t.`summary`, t.`description`, t.`status`, t.`category`, t.`version`, t.`ticketLifeStatus` FROM demo.ticketdefect t inner join demo.usermaster u on u.id=t.assignedTo WHERE u.`id`=?", BeanPropertyRowMapper.newInstance(TicketDefectMaster.class),id);
		
	}
	

}
