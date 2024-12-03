package org.oop.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketPoolDto {
    private String id;
    private int availableTickets;
    private int addedTickets;
    private int removedTickets;
}
