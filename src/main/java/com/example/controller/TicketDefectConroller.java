package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AdminTicketResponse;
import com.example.model.ApiResponse;
import com.example.model.TicketDefectMaster;
import com.example.service.TicketDefectService;

import jakarta.servlet.http.HttpSession;

@RestController
public class TicketDefectConroller {
@Autowired
	private TicketDefectService ticket;
@PostMapping("/saveTicket")
public int getDefectTicket(@RequestBody TicketDefectMaster ticketDefectMaster) {
	return ticket.saveDefect(ticketDefectMaster);
}
	
@PutMapping("/updateTicketByQa")
public ApiResponse updateDefect(@RequestBody TicketDefectMaster ticketDefectMaster,HttpSession session) {
	
	ApiResponse apiResponse=new ApiResponse();
	try {
		
	if(session.getAttribute("role").toString().equalsIgnoreCase("Qa")) 
	{
		
	long result= ticket.updateDefectQA(ticketDefectMaster);	
	if(result>0)
	{
		apiResponse.setCode("0000");
		apiResponse.setMessage("Sucessfully Updated");
		return apiResponse;
		
	}else {
		apiResponse.setCode("9999");
		apiResponse.setMessage("Not  Updated");
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
@PutMapping("/updateTicketByDev")
public ApiResponse updateDefectDev(@RequestBody TicketDefectMaster ticketDefectMaster,HttpSession session) {
	
	ApiResponse apiResponse=new ApiResponse();
	try {
		
	if(session.getAttribute("role").toString().equalsIgnoreCase("Dev")) 
	{
		
	long result= ticket.updateDefectDev(ticketDefectMaster);	
	if(result>0)
	{
		apiResponse.setCode("0000");
		apiResponse.setMessage("Sucessfully Updated");
		return apiResponse;
		
	}else {
		apiResponse.setCode("9999");
		apiResponse.setMessage("Not  Updated");
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
@DeleteMapping("/deleteTicket/{id}")
public ApiResponse deleteDefect(@PathVariable Long id,HttpSession session) {
	
	ApiResponse apiResponse=new ApiResponse();
	try {
		
	if(session.getAttribute("role").toString().equalsIgnoreCase("Admin")) 
	{
		
	int result= ticket.deletDefect(id);
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
@GetMapping("/showAllTickets")
public ApiResponse showAllTickets(HttpSession session)
{
	ApiResponse apiResponse=new ApiResponse();
	try {
		
	if(session.getAttribute("role").toString().equalsIgnoreCase("Admin")) 
	{
		List<AdminTicketResponse> list= ticket.showAllTickets();
		 apiResponse.setCode("0000");
		apiResponse.setMessage("Sucess");
		apiResponse.setData(list);
			return apiResponse;
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
@GetMapping("/showAllTicketsToQa/{id}")
public ApiResponse showAllTicketsToQa(@PathVariable Long id,HttpSession session){
	ApiResponse apiResponse=new ApiResponse();
	try {
		
	if(session.getAttribute("role").toString().equalsIgnoreCase("Qa")) 
	{
		
		List<TicketDefectMaster> result=  ticket.showAllTicketsToQa(id);
	if(result!=null&&result.size()>0)
	{
		apiResponse.setCode("0000");
		apiResponse.setMessage("Sucess");
		apiResponse.setData(result);
		return apiResponse;
		
	}else {
		apiResponse.setCode("9999");
		apiResponse.setMessage("Data not found.!");
		apiResponse.setData(result);
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
			apiResponse.setMessage("You are not Authorised for this data:");
			return apiResponse;
		
		}
	
}

}
