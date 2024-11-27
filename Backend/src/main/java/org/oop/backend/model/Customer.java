package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "customers")
@Data
@Builder
public class Customer {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    private String password;
    private Boolean vip;
    private Integer ticketsBought;


    public void setTicketsBought(Integer ticketsBought) {
        this.ticketsBought = ticketsBought;
    }
}




