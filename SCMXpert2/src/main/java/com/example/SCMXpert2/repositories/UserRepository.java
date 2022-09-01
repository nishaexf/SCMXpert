package com.example.SCMXpert2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SCMXpert2.models.Users;

@Repository
public interface UserRepository extends MongoRepository<Users,String>{
	 Users findByEmail(String email);

	 Users findByResetToken(String resetToken);
}
