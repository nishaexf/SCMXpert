package com.example.SCMXpert2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SCMXpert2.models.ForgetPassword;
import com.example.SCMXpert2.models.*;
import com.example.SCMXpert2.models.Users;
import com.example.SCMXpert2.repositories.UserRepository;
import com.example.SCMXpert2.services.EmailServiceImpl;



//https://github.com/Ashish-pal/EmployeeManagement
@Controller
@RequestMapping("/forgetPassword")
public class ForgotController {

	
	@Autowired
	private UserRepository userRepository;
	

	//@Autowired
	private EmailServiceImpl emailService;

	
	
	public ForgotController(EmailServiceImpl emailService) {
		super();
		this.emailService = emailService;
	}
	
	@ModelAttribute("forgetEmail")
	public ForgetPassword userRegistrationDto(Model model) {

		return new ForgetPassword();
	}
	
	// Display forgotPassword page
	@GetMapping
	public String getUser() {
		
		return "forgot";
	}
	
	@PostMapping
	public String  forgetPassword(@ModelAttribute("forgetEmail") Users users) {
		Users user = userRepository.findByEmail(users.getEmail());
		 if(user==null){
	         
	            return  "Couldn't find an account for that email.";
	        }
		try {
			boolean res =emailService.sendOtp(user.getEmail());
			if(res) {
				return "Mail send successfully";
			}
		} catch (Exception e) {
		 
			e.printStackTrace();
		}
		
		return "forgot";
		 
	}
}
