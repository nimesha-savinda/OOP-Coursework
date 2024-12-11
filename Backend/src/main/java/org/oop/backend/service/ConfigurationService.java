package org.oop.backend.service;

import org.oop.backend.dto.ConfigurationDto;
import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Configuration;
import org.oop.backend.model.Customer;
import org.oop.backend.model.TicketPool;
import org.oop.backend.repository.ConfigurationRepository;
import org.oop.backend.repository.TicketPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private TicketPoolService ticketPoolService;

    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    public String saveConfiguration(ConfigurationDto configurationDto){
        try{
            Configuration configuration = Configuration.builder().
                    Total_number_of_tickets(configurationDto.getTotal_number_of_tickets()).
                    Ticket_release_rate(configurationDto.getTicket_release_rate()).
                    Retrieval_rate(configurationDto.getRetrieval_rate()).
                    Maximum_Capacity(configurationDto.getMaximum_Capacity()).build();

            configurationRepository.save(configuration);
            TicketPool t1 = new TicketPool(
                    configurationDto.getTotal_number_of_tickets(),
                    0,0);
            ticketPoolRepository.save(t1);


            return " Successfully added to the database";
        }catch(Exception e){
            return e.getMessage();

        }
    }
    public Configuration findTheLatestEntry(){
        return configurationRepository.findFirstByOrderByIdDesc();
    }
}
