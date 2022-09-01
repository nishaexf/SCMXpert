package com.example.SCMXpert2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SCMXpert2.models.RouteDetails;
import com.example.SCMXpert2.repositories.RouteDetail;
@Service
public class RoutesService {

	
	@Autowired
	private RouteDetail detailRepo;
	
	public List<RouteDetails> populateList() {
	    List<RouteDetails> options = new ArrayList<RouteDetails>();
	    options.add(new RouteDetails("US-Mumbai,India"));
	    options.add(new RouteDetails("US-Hyderabad,India"));
	    options.add(new RouteDetails("US-Chennai,India"));
	    
	    return options;
	}
	
	
	public RouteDetails saveList() {
		
		return detailRepo.findByName(populateList());
	}
	
	


	



}
