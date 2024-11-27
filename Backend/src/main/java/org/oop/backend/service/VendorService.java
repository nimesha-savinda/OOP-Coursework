package org.oop.backend.service;

import org.oop.backend.dto.VendorDto;
import org.oop.backend.model.Vendor;
import org.oop.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;


    public String createVendor(VendorDto vendorDto){

        try {
            Vendor vendor = Vendor.builder().id(vendorDto.getId()).
                    username(vendorDto.getUsername()).
                    password(vendorDto.getPassword()).
                    ticketsAdded(vendorDto.getTicketsAdded()).build();
            vendorRepository.save(vendor);
        }catch(Exception e){
            return e.getMessage();
        }
        return "Successfully created";
    }
    public String ticketsRemoved(String id, Integer ticket_count){
        try{
        Optional<Vendor> optionalVendor = vendorRepository.findById(id);
        Vendor vendor = optionalVendor.get();
        vendor.setTicketsAdded(vendor.getTicketsAdded()+ticket_count);
        vendorRepository.save(vendor);
        return "Record Updated...!";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    public Vendor checkDetails(String username){
        return vendorRepository.findVendorByUsername(username);
    }
}
