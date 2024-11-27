package org.oop.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private String id;
    private String username;
    private String password;
    private Boolean vip;
    private Integer ticketsBought;
}


