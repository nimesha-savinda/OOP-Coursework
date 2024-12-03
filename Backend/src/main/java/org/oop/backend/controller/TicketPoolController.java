package org.oop.backend.controller;


import org.oop.backend.dto.TicketPoolDto;
import org.oop.backend.dto.VendorDto;
import org.oop.backend.model.TicketPool;
import org.oop.backend.service.TicketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ticket-pool")
public class TicketPoolController {

   @Autowired
   private TicketPoolService ticketPoolService;

   @PostMapping("/create")
   @ResponseStatus(HttpStatus.CREATED)
   public String createTicketPool(@RequestBody TicketPoolDto ticketPoolDto){
      return ticketPoolService.createTicketPool(ticketPoolDto);

   }
   @GetMapping("/get")
   @ResponseStatus(HttpStatus.ACCEPTED)
   public TicketPool getTheLatestTicketPool(){
      return ticketPoolService.getlatestTicketPool();
   }


}
