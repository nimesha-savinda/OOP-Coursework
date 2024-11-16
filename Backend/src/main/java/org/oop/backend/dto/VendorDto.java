package org.oop.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VendorDto {
    private Long id;
    private String username;
    private String password;
    private Integer ticketsAdded;
}
