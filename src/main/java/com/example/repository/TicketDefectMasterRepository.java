package com.example.repository;

import java.util.List;

import com.example.model.AdminTicketResponse;
import com.example.model.TicketDefectMaster;

public interface TicketDefectMasterRepository {

	int save(TicketDefectMaster ticketDefectMaster);
	long updateByDev(TicketDefectMaster ticketDefectMaster);
	long updateByQA(TicketDefectMaster ticketDefectMaster);
	int deleteById(Long id);
	TicketDefectMaster getTicketById(Long id);
	List<AdminTicketResponse> showAll();
	
	List<TicketDefectMaster> showToQA(Long id);
	
	
}
