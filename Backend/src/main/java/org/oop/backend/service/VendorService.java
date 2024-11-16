package org.oop.backend.service;

import org.oop.backend.dto.CustomerDto;
import org.oop.backend.dto.VendorDto;
import org.oop.backend.model.Customer;
import org.oop.backend.model.Vendor;
import org.oop.backend.repository.CustomerRepository;
import org.oop.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public String createVendor(VendorDto vendorDto){

        try {
            Vendor vendor = Vendor.builder().id(vendorDto.getId()).
                    username(vendorDto.getUsername()).
                    password(vendorDto.getPassword()).build();
        }catch(Exception e){
            return e.getMessage();
        }
        return "Successfully created";
    }


}
