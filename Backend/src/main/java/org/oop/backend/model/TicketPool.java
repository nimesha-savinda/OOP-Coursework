package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class TicketPool {
    @Id
    private String id;
    private int availableTickets;
    private int addedTickets;
    private int removedTickets;

    public TicketPool() {
    }
    public TicketPool( int availableTickets) {
        this.availableTickets = availableTickets;
    }
    public TicketPool(String id, int availableTickets, int addedTickets, int removedTickets) {
        this.id = id;
        this.availableTickets = availableTickets;
        this.addedTickets = addedTickets;
        this.removedTickets = removedTickets;
    }
    public TicketPool(int availableTickets, int addedTickets, int removedTickets) {
        this.availableTickets = availableTickets;
        this.addedTickets = addedTickets;
        this.removedTickets = removedTickets;
    }
}
