package com.ashmitagarwal.shopping_mvc_part2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ashmitagarwal.shopping_mvc_part2.models.UserLoginDetails;
import com.ashmitagarwal.shopping_mvc_part2.models.UserRegistrationDetails;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("username")
public class HomeController {
	
	@RequestMapping("/")
	public String homePage(Model model) {
		
		String username =  (String) model.getAttribute("username");
		if(username != null)
		{
			System.out.println("Username found in session @homePage: " + username);
			return "UserLoginSuccessPage";
		}
		return "HomePage";
	}
	
	@GetMapping("/userLogin")
	public String userLogin(Model model) {
		
		String username =  (String) model.getAttribute("username");
		if(username != null)
		{
			System.out.println("Username found in session @userLogin: " + username);
			return "UserLoginSuccessPage";
		}
		return "UserLoginPage";
	}
	
	@GetMapping("/userRegistration")
	public String userRegistration(Model model) {
		
		String username =  (String) model.getAttribute("username");
		if(username != null)
		{
			System.out.println("Username found in session @userRegistration: " + username);
			return "UserLoginSuccessPage";
		}
		return "UserRegistrationPage";
	}
	
	@PostMapping("/userLogin")
	public String userLogin(UserLoginDetails userLoginDetails, Model model) {
		String username = userLoginDetails.getUsername();
		String password = userLoginDetails.getPassword();
		
		System.out.println(username);
		System.out.println(password);
		
		if(!username.isBlank() && !password.isBlank())
		{
			if(username.equals("ashmit") && password.equals("password")) {
				model.addAttribute("username", username);
				return "UserLoginSuccessPage";
			}

		}
		return "UserLoginFailedPage";
	}
	
	@PostMapping("/userRegistration")
	public String userRegistration(UserRegistrationDetails userRegistrationDetails, Model model, HttpServletRequest httpRequest) {
		
		String fname = userRegistrationDetails.getFirstname();
		String mname = userRegistrationDetails.getMiddlename();
		String lname = userRegistrationDetails.getLastname();
		String username = userRegistrationDetails.getUsername();
		String email = userRegistrationDetails.getEmail();
		String password = userRegistrationDetails.getPassword();
		
		System.out.println(fname);
		System.out.println(mname);
		System.out.println(lname);
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		
		if(!fname.isBlank() && !username.isBlank() && !email.isBlank() && !password.isBlank())
		{
			model.addAttribute("username", username);
			return "UserRegistrationSuccessPage";
		}
		return "UserRegistrationFailedPage";
	}
	
	@RequestMapping("/userLogout")
	public String userLogout(Model model, SessionStatus status) {
		
		String username =  (String) model.getAttribute("username");
		if(username != null)
		{
			System.out.println("Username found in session @userLogout: " + username);
			status.setComplete();
		}
		return "UserLoginPage";
	}
}
