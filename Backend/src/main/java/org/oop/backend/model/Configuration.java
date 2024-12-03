package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="configuration files")
@Data
@Builder
@NoArgsConstructor
public class Configuration {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Integer Total_number_of_tickets;
    private  Integer Ticket_release_rate;
    private  Integer Retrieval_rate;
    private  Integer Maximum_Capacity;

    public Configuration(String id,Integer Total_number_of_tickets,Integer Ticket_release_rate,Integer Retrieval_rate,
                         Integer Maximum_Capacity){
        this.id = id;
        this.Total_number_of_tickets=Total_number_of_tickets;
        this.Ticket_release_rate=Ticket_release_rate;
        this.Retrieval_rate=Retrieval_rate;
        this.Maximum_Capacity=Maximum_Capacity;
    }
    public Configuration(Integer Total_number_of_tickets,Integer Ticket_release_rate,Integer Retrieval_rate,
                         Integer Maximum_Capacity){
        this.Total_number_of_tickets=Total_number_of_tickets;
        this.Ticket_release_rate=Ticket_release_rate;
        this.Retrieval_rate=Retrieval_rate;
        this.Maximum_Capacity=Maximum_Capacity;
    }
}
