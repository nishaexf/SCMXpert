package com.example.SCMXpert2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SCMXpert2.models.ShipmentDetails;

public interface ShipmentRepository extends MongoRepository<ShipmentDetails,String>{

}
