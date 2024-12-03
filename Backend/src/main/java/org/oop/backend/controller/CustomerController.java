package org.oop.backend.controller;


import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Customer;
import org.oop.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/login/check/{username}")
    public Customer checkDetails(@RequestParam String username){
        return customerService.checkDetails(username);
    }

//    @PostMapping("/ticketBought")
//    public void ticketBought(Customer customer,Integer ticket_count){
//        customerService.updateTicketsRemoved(customer,ticket_count);
//    }
    @PutMapping("/{id}/remove-tickets")
    public String checkDetails(@PathVariable String id,@RequestParam Integer ticket_count){
        return customerService.ticketsRemoved(id,ticket_count);
    }

//    @GetMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String updateConfig(@RequestParam int x){
//        return customerService.ticketRemove(x);
//    }


}
