package com.ashmitagarwal.shopping_mvc_part1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ashmitagarwal.shopping_mvc_part1.models.ShoppingListDTO;
import com.ashmitagarwal.shopping_mvc_part1.models.UserLoginDetails;
import com.ashmitagarwal.shopping_mvc_part1.models.UserRegistrationDetails;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage() {
		return "HomePage";
	}
	
	@GetMapping("/userLogin")
	public String userLogin(Model model) {
		UserLoginDetails userLoginDetails = new UserLoginDetails();
		model.addAttribute(userLoginDetails);		
		return "UserLoginPage";
	}
	
	@GetMapping("/userRegistration")
	public String userRegistration() {
		return "UserRegistrationPage";
	}
	
	@ResponseBody
	@PostMapping("/userLogin")
	public ModelAndView userLogin(UserLoginDetails userLoginDetails, @ModelAttribute("shoppingList") ShoppingListDTO shoppingList) {
		String username = userLoginDetails.getUsername();
		String password = userLoginDetails.getPassword();
		
		System.out.println(username);
		System.out.println(password);
		
		if(!username.isBlank() && !password.isBlank())
		{
			if(username.equals("ashmit") && password.equals("password")) {
				ModelAndView modelAndView = new ModelAndView("UserLoginSuccessPage");
				modelAndView.addObject(userLoginDetails);
				return modelAndView;
			}

		}
		ModelAndView modelAndView = new ModelAndView("UserLoginFailedPage");
		return modelAndView;
	}
	
	@PostMapping("/userRegistration")
	public String userRegistration(UserRegistrationDetails userRegistrationDetails, HttpServletResponse response) {
		
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
			Cookie newCookie = new Cookie("Shopping.username", fname);
			newCookie.setMaxAge(24*60*60);
			response.addCookie(newCookie);
			return "UserRegistrationSuccessPage";
		}
		return "UserRegistrationFailedPage";
	}
}
