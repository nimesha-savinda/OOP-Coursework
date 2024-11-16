package org.oop.backend.service;

import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Customer;
import org.oop.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String createCustomer(CustomerDto customerDto){

        try {
            Customer customer = Customer.builder().id(customerDto.getId()).
                    username(customerDto.getUsername()).
                    password(customerDto.getPassword()).
                    vip(customerDto.getVip()).build();
        }catch(Exception e){
            return e.getMessage();
        }
        return "Successfully created";
    }


}
