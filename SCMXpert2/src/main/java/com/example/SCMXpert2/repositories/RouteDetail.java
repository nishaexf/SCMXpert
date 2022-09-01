package com.example.SCMXpert2.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SCMXpert2.models.RouteDetails;

public interface RouteDetail extends MongoRepository<RouteDetails,String>{

	RouteDetails findByName(List<RouteDetails> list);
}
