package com.ashmitagarwal.shopping_mvc_part1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashmitagarwal.shopping_mvc_part1.models.ShoppingListDTO;

@Controller
public class ShoppingListController {
	
	@PostMapping("/saveShoppingList")
	public String saveShoppingList(@ModelAttribute("shoppingList") ShoppingListDTO shoppingList, @CookieValue("Shopping.username") String username, Model model) {
		
		String itemName = shoppingList.getItemName();
		String itemType = shoppingList.getItemType();
		String itemPrice = shoppingList.getItemPrice();
		
		System.out.println(itemName);
		System.out.println(itemType);
		System.out.println(itemPrice);
		
		System.out.println(username);
		model.addAttribute("username", username);
		
		return "DisplayShoppingListPage";
	}
}
