package org.oop.backend.controller;


import org.oop.backend.service.TicketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketPoolController {

   @Autowired
   private TicketPoolService ticketPoolService;

//   @PostMapping("/create")
//   private


}
