package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class TicketPool {
    private int availableTickets;
    private int addedTickets;
    private int removedTickets;
}
