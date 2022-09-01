package com.example.SCMXpert2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.SCMXpert2.models.ForgetPassword;

public interface ResetPasswordRepository extends MongoRepository<ForgetPassword, Integer> {
//	ResetToken findByConfirmationToken(String confirmationToken);
	

	
	public ForgetPassword findByEmailAndOtpGerated(String email, String otp);
}