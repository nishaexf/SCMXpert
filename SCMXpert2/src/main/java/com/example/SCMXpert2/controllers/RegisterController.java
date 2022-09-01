package com.example.SCMXpert2.controllers;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.SCMXpert2.models.ReCaptchaResponse;
import com.example.SCMXpert2.models.Users;
import com.example.SCMXpert2.services.UserRegisterService;




@Controller
@RequestMapping("/register")
public class RegisterController {

	private UserRegisterService userService;
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public RegisterController(UserRegisterService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public Users data() {
		return new Users();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "signup";
	}

	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		StringTrimmerEditor stringEditor=new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, stringEditor);
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user")@Valid Users registrationDto,BindingResult results,@RequestParam(name="g-recaptcha-response") String captchaResponse) {
		String url = "https://www.google.com/recaptcha/api/siteverify";
		String params = "?secret=6Lcc0HwUAAAAAE95NcYpjnL1eQ-EuIpViecOpWRQ&response="+captchaResponse;
		ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url+params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();
		if(results.hasErrors()) {
			return "redirect:/register?error";
		}
	
		if(reCaptchaResponse.isSuccess()) {
			userService.save(registrationDto);

			return "redirect:/register?success";
		} else {
			
			return "redirect:/register?error";
		}
		
		
		
	
}
}