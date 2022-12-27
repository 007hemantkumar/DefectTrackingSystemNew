package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AdminTicketResponse;
import com.example.model.TicketDefectMaster;
import com.example.repository.TicketDefectMasterRepository;

@Service
public class TicketDefectService {
    @Autowired
	private TicketDefectMasterRepository repo;
    
    
    public int saveDefect(TicketDefectMaster ticketDefectMaster) {
    	 return repo.save(ticketDefectMaster);
    }
    
    public long updateDefect(TicketDefectMaster ticketDefectMaster) {
    	return repo.updateByDev(ticketDefectMaster);
    }
    public long updateDefectQA(TicketDefectMaster ticketDefectMaster) {
    	return repo.updateByQA(ticketDefectMaster);
    }

    public long updateDefectDev(TicketDefectMaster ticketDefectMaster) {
    	return repo.updateByDev(ticketDefectMaster);
    }
    public int deletDefect(Long id) {
    	return repo.deleteById(id);
    }
    
    public List<AdminTicketResponse> showAllTickets(){
    	return repo.showAll();
    }
    
    public List<TicketDefectMaster> showAllTicketsToQa(Long id){
    	return repo.showToQA(id);
    }
}
