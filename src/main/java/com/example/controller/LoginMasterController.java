package com.example.controller;

import java.security.SecureRandom;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LoginResponse;
import com.example.model.TicketDefectMaster;
import com.example.model.UserMaster;
import com.example.service.LoginService;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginMasterController {
    @Autowired
	private LoginService loginService;
    @Autowired
    private HttpSession httpSession;
    
     
    @PostMapping("/login")
	public LoginResponse loginUser(@RequestBody UserMaster userMaster) {
    	LoginResponse loginResponse = new LoginResponse();
    	UserMaster user = loginService.loginUser(userMaster);
    	if(user!=null)
    	{
    		   String uuid = UUID.randomUUID().toString();
    		loginResponse.setCode("0000");
    		loginResponse.setMessage("successfull login.");
    		loginResponse.setToken("");
    		httpSession.setAttribute("userMaster", user.getUserName());
    		httpSession.setAttribute("role", user.getUserRole());
    		httpSession.setAttribute("token", uuid);
    		return loginResponse;
    	}else {
    		loginResponse.setCode("1111");
    		loginResponse.setMessage("User name and password wrong please try agin.");
    		loginResponse.setToken("");
		return loginResponse;
    	}
	}
    @GetMapping("/logout")
    public UserMaster logoutUser(@RequestBody UserMaster userMaster,HttpSession session) {
    	LoginResponse loginResponse = new LoginResponse();
    	UserMaster user = loginService.logoutUser(userMaster);


    	try {
    		//httpSession.invalidate();
    		
    		session.setAttribute("token", "");
    		
    		if(user==null) {
    			loginResponse.setCode("0000");
    			loginResponse.setMessage("User logout Sucessfull.!");
        		loginResponse.setToken("");
    		}
    		
    	}catch (Exception e) {
			// TODO: handle exception
		}
		return loginService.logoutUser(userMaster);
    	
    }

    @PostMapping("/QACreateDefect")
    public int QACreateDefects(@RequestBody TicketDefectMaster ticketDefectMaster,HttpSession session) {
    	
    System.out.println(session.getAttribute("role"));
    	return loginService.QACreateDefect(ticketDefectMaster);
    }
    
}
