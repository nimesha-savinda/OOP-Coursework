package org.oop.backend.controller;


import org.oop.backend.dto.CustomerDto;
import org.oop.backend.dto.VendorDto;
import org.oop.backend.service.ConfigService;
import org.oop.backend.service.CustomerService;
import org.oop.backend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/customer")
public class VendorController {
    @Autowired
    private VendorService vendorService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@RequestBody VendorDto vendor){
        return vendorService.createVendor(vendor);

    }




}
