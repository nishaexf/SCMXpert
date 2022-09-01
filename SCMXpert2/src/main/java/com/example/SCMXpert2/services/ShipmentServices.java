package com.example.SCMXpert2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SCMXpert2.models.ShipmentDetails;
import com.example.SCMXpert2.repositories.ShipmentRepository;
@Service
public class ShipmentServices {
	@Autowired
	private ShipmentRepository detailRepo;
	
	
	  public ShipmentServices(ShipmentRepository detailRepo) {
		super();
		this.detailRepo = detailRepo;
	}


	public void saveShipment(ShipmentDetails details) {
		
		  detailRepo.save(details);
	    }

}
