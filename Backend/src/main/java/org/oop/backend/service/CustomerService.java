package org.oop.backend.service;

import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Customer;
import org.oop.backend.model.Vendor;
import org.oop.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public String saveCustomer(CustomerDto customerDto){
        try{
            Customer customer = Customer.builder().id(customerDto.getId()).
                    username(customerDto.getUsername()).
                    password(customerDto.getPassword()).
                    vip(customerDto.getVip()).build();
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
    public Customer checkDetails(String username){
        return customerRepository.findCustomerByUsername(username);
    }

}
