package org.oop.backend.service;

import org.oop.backend.dto.VendorDto;
import org.oop.backend.model.Configuration;
import org.oop.backend.model.TicketPool;
import org.oop.backend.model.Vendor;
import org.oop.backend.repository.ConfigurationRepository;
import org.oop.backend.repository.TicketPoolRepository;
import org.oop.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private TicketPoolRepository ticketPoolRepository;

    @Autowired
    private ConfigurationRepository configurationRepository;


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
    public String ticketsAdded(String id, Integer ticket_count){

        Configuration current_configuration = configurationRepository.findFirstByOrderByIdDesc();

        if(current_configuration.getTicket_release_rate()>=ticket_count) {
            try {
                Optional<Vendor> optionalVendor = vendorRepository.findById(id);
                Vendor vendor = optionalVendor.get();
                vendor.setTicketsAdded(vendor.getTicketsAdded() + ticket_count);
                vendorRepository.save(vendor);

                TicketPool optionalTicketPoolService = ticketPoolRepository.findFirstByOrderByIdDesc();
                optionalTicketPoolService.setAddedTickets(optionalTicketPoolService.getAddedTickets() + ticket_count);
                optionalTicketPoolService.setAvailableTickets(optionalTicketPoolService.getAvailableTickets() + ticket_count);
                ticketPoolRepository.save(optionalTicketPoolService);

                return "Record Updated...!";
            } catch (Exception e) {
                return "Failed to update..!" + e.getMessage();
            }
        }else{
            return "Ticket release rate exceeded..!";
        }
    }
    public Vendor checkDetails(String username){
        return vendorRepository.findVendorByUsername(username);
    }
}
