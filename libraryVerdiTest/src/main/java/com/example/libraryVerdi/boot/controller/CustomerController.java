package com.example.libraryVerdi.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.libraryVerdi.boot.model.Customer;
import com.example.libraryVerdi.boot.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping("/show")
	public String showCusotmers(Model model) {

		model.addAttribute("clients", service.findAll());
		return "library/clients.html";
	}
	
	@RequestMapping("/AddCustomer")
	public String addCustomer (Model model) {
		
		return "library/addClient.html";
	}

	@RequestMapping("/insertCustomer")
	public String insertCreditCard(Customer customer,Model model) {
		
		service.insertCustomer(customer);
			
		model.addAttribute("clients", service.findAll());
		return "library/Cart.html";
	}
	
	
}
