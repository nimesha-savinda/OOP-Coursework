package org.oop.backend.repository;

import org.oop.backend.model.Customer;
import org.oop.backend.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends MongoRepository<Vendor,Long> {
    Vendor findVendorByUsername(String username);

    Optional<Vendor> findById(String id);
}


