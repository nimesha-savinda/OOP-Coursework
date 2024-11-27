package org.oop.backend.repository;

import org.oop.backend.model.Configuration;
import org.oop.backend.model.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigurationRepository extends MongoRepository<Configuration,Long>{

    Configuration findFirstByOrderByIdDesc();

}
