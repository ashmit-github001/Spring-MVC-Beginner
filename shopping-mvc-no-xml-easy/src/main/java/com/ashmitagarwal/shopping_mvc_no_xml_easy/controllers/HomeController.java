package com.ashmitagarwal.shopping_mvc_no_xml_easy.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@ResponseBody
	@RequestMapping("/test")
	public String test() {
		return "Hello World";
	}
	
	@RequestMapping("/")
	public String homePage() {
		return "HomePage";
	}
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "UserLoginPage";
	}
	
	@GetMapping("/userRegistration")
	public String userRegistration() {
		return "UserRegistrationPage";
	}
	
	@ResponseBody
	@PostMapping("/userLogin")
	public String userLogin(@RequestParam Map<String,String> userLoginDetails) {
		String username = userLoginDetails.get("username");
		String password = userLoginDetails.get("password");
		
		System.out.println(username);
		System.out.println(password);
		
		if(!username.isBlank() && !password.isBlank())
		{
			if(username.equals("ashmit") && password.equals("password"))
				return "You are logged  in!";
		}
		return "Invalid information, please try again! :(";
	}
	
	@ResponseBody
	@PostMapping("/userRegistration")
	public String userRegistration(@RequestParam Map<String,String> userRegistrationDetails) {
		
		String fname = userRegistrationDetails.get("firstname");
		String mname = userRegistrationDetails.get("middlename");
		String lname = userRegistrationDetails.get("lastname");
		String username = userRegistrationDetails.get("username");
		String email = userRegistrationDetails.get("email");
		String password = userRegistrationDetails.get("password");
		
		System.out.println(fname);
		System.out.println(mname);
		System.out.println(lname);
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		
		if(!fname.isBlank() && !username.isBlank() && !email.isBlank() && !password.isBlank())
		{
			return "Congratulations! You are registered.!";
		}
		return "Invalid information, please try again! :(";
	}
}
