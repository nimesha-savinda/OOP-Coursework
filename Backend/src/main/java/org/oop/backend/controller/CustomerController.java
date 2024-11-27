package org.oop.backend.controller;


import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Customer;
import org.oop.backend.service.ConfigurationService;
import org.oop.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@RequestBody CustomerDto customer){
        return customerService.saveCustomer(customer);

    }

    @GetMapping("/getLatest")
    public Customer getLatest(){
        return customerService.findTheLatestEntry();

    }

    @PostMapping("/ticketBought")
    public void ticketBought(Customer customer,Integer ticket_count){
        customerService.updateTicketsRemoved(customer,ticket_count);
    }

//    @GetMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String updateConfig(@RequestParam int x){
//        return customerService.ticketRemove(x);
//    }


}
