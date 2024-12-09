package org.oop.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "vendors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Vendor {
    @Id
    private String id;
    private String username;
    private String password;
    private Integer ticketsAdded;

    

    public Vendor(String username,String password,Integer ticketsAdded){
        this.username = username;
        this.password = password;
        this.ticketsAdded = ticketsAdded;
    }


}
