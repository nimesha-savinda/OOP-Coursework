package org.oop.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ConfigurationDto {
    private String id;
    private Integer Total_number_of_tickets;
    private  Integer Ticket_release_rate;
    private  Integer Retrieval_rate;
    private  Integer Maximum_Capacity;
}
