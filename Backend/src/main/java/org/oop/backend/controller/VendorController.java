package org.oop.backend.controller;


import org.oop.backend.dto.CustomerDto;
import org.oop.backend.dto.VendorDto;
import org.oop.backend.model.Vendor;
import org.oop.backend.service.CustomerService;
import org.oop.backend.service.TicketPoolService;
import org.oop.backend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @Autowired
    private TicketPoolService ticketPoolService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@RequestBody VendorDto vendor){
        return vendorService.createVendor(vendor);

    }
    @GetMapping("/login/check/{username}")
    public Vendor checkDetails(@PathVariable String username){
        return vendorService.checkDetails(username);
    }

    @PutMapping("/{id}/add-tickets")
    public String addTickets(@PathVariable String id,@RequestParam Integer ticket_count){
        return vendorService.ticketsRemoved(id,ticket_count);


    }


//    @GetMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String updateConfig(@RequestParam int x){
//        return vendorService.ticketAdd(x);
//    }

}
