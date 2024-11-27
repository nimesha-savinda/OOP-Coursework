package org.oop.backend.repository;

import org.oop.backend.model.TicketPool;
import org.oop.backend.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPoolRepository extends MongoRepository<TicketPool,Long> {

}

