package com.example.SCMXpert2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SCMXpert2.models.accessingMongodb;

@Repository
public interface accessData extends MongoRepository<accessingMongodb, String>
{

}
