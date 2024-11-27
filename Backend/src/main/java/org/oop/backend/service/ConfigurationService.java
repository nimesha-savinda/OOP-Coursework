package org.oop.backend.service;

import org.oop.backend.dto.ConfigurationDto;
import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Configuration;
import org.oop.backend.model.Customer;
import org.oop.backend.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    @Autowired
    private ConfigurationRepository configurationRepository;

    public String saveConfiguration(ConfigurationDto configurationDto){
        try{
            Configuration configuration = Configuration.builder().
                    Total_number_of_tickets(configurationDto.getTotal_number_of_tickets()).
                    Ticket_release_rate(configurationDto.getTicket_release_rate()).
                    Retrieval_rate(configurationDto.getRetrieval_rate()).
                    Maximum_Capacity(configurationDto.getMaximum_Capacity()).build();
            configurationRepository.save(configuration);
            return " Successfully added to the database";
        }catch(Exception e){
            return e.getMessage();

        }
    }
    public Configuration findTheLatestEntry(){
        return configurationRepository.findFirstByOrderByIdDesc();
    }
}
