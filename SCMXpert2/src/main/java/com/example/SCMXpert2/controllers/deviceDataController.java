package com.example.SCMXpert2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SCMXpert2.models.accessingMongodb;
import com.example.SCMXpert2.repositories.accessData;

@RestController
public class deviceDataController {

	
	private accessData accessRepo;
	
	@GetMapping("/DataStream")
	public ResponseEntity<?> getAllAccess() {
	List<accessingMongodb> DataStream =accessRepo.findAll();
	if(DataStream.size()>0) {
		return new ResponseEntity<List<accessingMongodb>>(DataStream,HttpStatus.OK);
	}else {
		return new ResponseEntity<>("No Data",HttpStatus.NOT_FOUND);
	}

}
}
