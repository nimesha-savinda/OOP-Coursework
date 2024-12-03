package org.oop.backend.service;

import org.oop.backend.dto.CustomerDto;
import org.oop.backend.dto.TicketPoolDto;
import org.oop.backend.model.Customer;
import org.oop.backend.model.TicketPool;
import org.oop.backend.repository.CustomerRepository;
import org.oop.backend.repository.TicketPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketPoolService {
    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    public String createTicketPool(TicketPoolDto ticketPoolDto){
        try{
            TicketPool ticketPool = TicketPool.builder().
                    availableTickets(ticketPoolDto.getAvailableTickets()).
                    addedTickets(ticketPoolDto.getAddedTickets()).
                    removedTickets(ticketPoolDto.getRemovedTickets()).build();
            ticketPoolRepository.save(ticketPool);
            return " Successfully added to the database";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public TicketPool getlatestTicketPool(){
        return ticketPoolRepository.findFirstByOrderByIdDesc();
    }

    public void updateAddedTickets(TicketPool ticketPool,Integer ticket_count){
        ticketPool.setAddedTickets(ticketPool.getAddedTickets()+ticket_count);
        ticketPool.setAvailableTickets(ticketPool.getAvailableTickets()+ticket_count);
    }

    public void updateRemovedTickets(TicketPool ticketPool,Integer ticket_count){
        ticketPool.setRemovedTickets(ticketPool.getRemovedTickets()+ticket_count);
        ticketPool.setAvailableTickets(ticketPool.getAvailableTickets()-ticket_count);
    }


}
