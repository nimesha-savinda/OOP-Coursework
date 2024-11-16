package org.oop.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Vendor {
    @Id
    private Long id;
    private String username;
    private String password;
    private Integer ticketsAdded;
}
