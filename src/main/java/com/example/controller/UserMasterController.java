package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.UserMaster;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController

public class UserMasterController {
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ApiResponse saveUser(@RequestBody UserMaster userMaster,HttpSession session) {

		
		ApiResponse apiResponse=new ApiResponse();
		try {
			
		if(session.getAttribute("role").toString().equalsIgnoreCase("Admin")) 
		{
			 
		int result= userService.save(userMaster);
		if(result>0)
		{
			apiResponse.setCode("0000");
			apiResponse.setMessage("Sucessfully Saved");
			return apiResponse;
			
		}else {
			apiResponse.setCode("9999");
			apiResponse.setMessage(" Data Not  Saved");
			return apiResponse;
		}
		}
		 else {
			 apiResponse.setCode("2222");
				apiResponse.setMessage("Session Expired");
				return apiResponse;
			
			 }
		 }catch (Exception e) {
			 apiResponse.setCode("1111");
				apiResponse.setMessage("Please contact to admin some technical issue");
				return apiResponse;
			
			}

		
	}

	@GetMapping("/get")
	public List<?> findAll(HttpSession session) {
		 try {
		 System.out.println(session.getAttribute("role"));
		
		 
		
		 if(session.getAttribute("role").toString().equalsIgnoreCase("Admin"))
		return userService.findAll();
		 else {
			 List<UserMaster> l=new ArrayList<>();
			 return l;
			 }
		 }catch (Exception e) {
			 List<String> l= new ArrayList<>();
			 l.add("Session Expire");
				return  l;
			}
	
	}
	
	/*
	 * @PutMapping("/update") public void updateUser(@RequestBody UserMaster
	 * userMaster) { userService.update(userMaster); }
	 */
	
	  @DeleteMapping("/delete/{id}") public ApiResponse deleteProduct(@PathVariable Long
	  id,HttpSession session) {

			ApiResponse apiResponse=new ApiResponse();
			try {
				
			if(session.getAttribute("role").toString().equalsIgnoreCase("Admin")) 
			{
				  
			int result=  userService.deleteUserById(id);
			if(result>0)
			{
				apiResponse.setCode("0000");
				apiResponse.setMessage("Sucessfully Deleted");
				return apiResponse;
				
			}else {
				apiResponse.setCode("9999");
				apiResponse.setMessage("Not  Deleted");
				return apiResponse;
			}
			}
			 else {
				 apiResponse.setCode("2222");
					apiResponse.setMessage("Session Expired");
					return apiResponse;
				
				 }
			 }catch (Exception e) {
				 apiResponse.setCode("1111");
					apiResponse.setMessage("Please contact to admin some technical issue");
					return apiResponse;
				
				}
		  
		 }
	 

	@GetMapping("/userById/{id}")
	public UserMaster searchById(@PathVariable Long id) {
		
		return userService.findById(id);
	}

	@GetMapping("/userRole/{userRole}")
	public ResponseEntity<?> getUserByRole(@PathVariable String userRole) {
		List<UserMaster> listusers=userService.findByRoleOfUser(userRole);
		return listusers.isEmpty()?new ResponseEntity<>("Role not found!",HttpStatus.BAD_REQUEST):new ResponseEntity<>(listusers,HttpStatus.OK);
	}

	@GetMapping("/userName/{userName}")
	public List<UserMaster> getUserByName(@PathVariable String userName) {
		return userService.FindByName(userName);
	}
}
