package org.oop.backend.repository;

import org.oop.backend.model.Customer;
import org.oop.backend.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Long> {
    Customer findCustomerByUsername(String username);
    Customer findFirstByOrderByIdDesc();
    Optional<Customer> findById(String id);
}

