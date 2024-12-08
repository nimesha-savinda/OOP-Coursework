package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "customers")
@Data
@Builder
public class Customer implements Runnable {
    @Id
    private String id;
    private String username;
    private String password;
    private Boolean vip;
    private Integer ticketsBought;
    private TicketPool pool;

    public Customer() {
    }

    public Customer(String id, String username, String password, Boolean vip, Integer ticketsBought) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.vip = vip;
        this.ticketsBought = ticketsBought;
    }


    public void setTicketsBought(Integer ticketsBought) {
        this.ticketsBought = ticketsBought;
    }

    public Customer(String username,String password,Boolean vip,Integer ticketsBought){
            this.username = username;
            this.password = password;
            this.vip = vip;
            this.ticketsBought = ticketsBought;
    }

    @Override
    public void run() {

    }
}




