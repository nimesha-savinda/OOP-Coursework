package org.oop.backend.controller;



import org.oop.backend.dto.ConfigurationDto;
import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Configuration;
import org.oop.backend.model.Customer;
import org.oop.backend.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/config")
public class ConfigController {
    @Autowired
    ConfigurationService configurationService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@RequestBody ConfigurationDto configurationDto){
        return configurationService.saveConfiguration(configurationDto);

    }

    @GetMapping("/getLatest")
    public Configuration getLatest() {
        return configurationService.findTheLatestEntry();
    }
}
