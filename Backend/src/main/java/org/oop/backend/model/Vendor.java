package org.oop.backend.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Vendors")
@Data
@Builder
public class Vendor {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String username;
    private String password;
    private Integer ticketsAdded;
}
