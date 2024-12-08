package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "ticket_pool")
@Data
@Builder
public class  TicketPool {
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

    public synchronized int getAvailableTickets() {
        return availableTickets;
    }

    public synchronized void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public synchronized int getAddedTickets() {
        return addedTickets;
    }

    public synchronized void setAddedTickets(int addedTickets) {
        this.addedTickets = addedTickets;
    }

    public synchronized int getRemovedTickets() {
        return removedTickets;
    }

    public synchronized void setRemovedTickets(int removedTickets) {
        this.removedTickets = removedTickets;
    }
}
