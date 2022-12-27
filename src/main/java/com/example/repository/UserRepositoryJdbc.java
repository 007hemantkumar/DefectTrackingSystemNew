package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.UserMaster;
@Repository
public class UserRepositoryJdbc implements UserRepository {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int save(UserMaster userMaster) {
		// TODO Auto-generated method stub
	 	return jdbcTemplate.update("INSERT INTO userMaster(userName,userRole,password) VALUES(?,?,?) ",
				new Object[] {userMaster.getUserName(),userMaster.getUserRole(),userMaster.getPassword()}) ;
		
	}

	@Override
	public int update(UserMaster userMaster) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE userMaster SET userName=?,userRole=?,password=? WHERE id=? ",
				new Object [] {userMaster.getUserName(),userMaster.getUserRole(),userMaster.getPassword(),userMaster.getId()});
	}

	@Override
	public UserMaster findById(Long id) {
		// TODO Auto-generated method stub
		UserMaster userMaster=jdbcTemplate.queryForObject("SELECT * FROM userMaster WHERE id=?", 
BeanPropertyRowMapper.newInstance(UserMaster.class),id);
		return userMaster;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM userMaster WHERE id=?",id);
	}

	public List<UserMaster> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM userMaster", BeanPropertyRowMapper.newInstance(UserMaster.class));
	}

 
 

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE form userMaster");
				}

	@Override
	public List<UserMaster> findByUserRole(String userRole) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM userMaster WHERE userRole=?", BeanPropertyRowMapper.newInstance(UserMaster.class),userRole);
	}

	@Override
	public List<UserMaster> findByUserName(String userName) {
		// TODO Auto-generated method stub
		String s="SELECT * from userMaster WHERE userName='"+userName+"'";
		return jdbcTemplate.query(s, BeanPropertyRowMapper.newInstance(UserMaster.class));
	}

}
