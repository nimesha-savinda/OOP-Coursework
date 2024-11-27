package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="configuration files")
@Data
@Builder
public class Configuration {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Integer Total_number_of_tickets;
    private  Integer Ticket_release_rate;
    private  Integer Retrieval_rate;
    private  Integer Maximum_Capacity;
}
