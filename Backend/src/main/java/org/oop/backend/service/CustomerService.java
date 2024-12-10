package org.oop.backend.service;

import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Customer;
import org.oop.backend.model.TicketPool;
import org.oop.backend.repository.CustomerRepository;
import org.oop.backend.repository.TicketPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService extends Thread {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    public String saveCustomer(CustomerDto customerDto){
        try{
            Customer customer = Customer.builder().id(customerDto.getId()).
                    username(customerDto.getUsername()).
                    password(customerDto.getPassword()).
                    vip(customerDto.getVip()).
                    ticketsBought(customerDto.getTicketsBought()).build();
            customerRepository.save(customer);
            return customerDto.getUsername()+" Successfully added to the database";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public Customer search(String username){
        return customerRepository.findCustomerByUsername(username);
    }
    public Customer findTheLatestEntry(){
        return customerRepository.findFirstByOrderByIdDesc();
    }

    public void updateTicketsRemoved(Customer customer,Integer ticket_count){
        customer.setTicketsBought(customer.getTicketsBought()+ticket_count);
    }

    public String ticketsRemoved(String id, Integer ticket_count){
        try{
            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            Customer customer = optionalCustomer.get();
            customer.setTicketsBought(customer.getTicketsBought()+ticket_count);
            customerRepository.save(customer);

            TicketPool optionalTicketPoolService = ticketPoolRepository.findFirstByOrderByIdDesc();
            optionalTicketPoolService.setRemovedTickets(optionalTicketPoolService.getRemovedTickets()+ticket_count);
            optionalTicketPoolService.setAvailableTickets(optionalTicketPoolService.getAvailableTickets()-ticket_count);
            ticketPoolRepository.save(optionalTicketPoolService);

            return "Record Updated...!";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    public Customer checkDetails(String username){
        return customerRepository.findCustomerByUsername(username);
    }

}
