package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomersController {

	@Autowired
	CustomerService cs;

	@RequestMapping(value = "/showCustomers.html")
	public String getCustomers(Model model) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		model.addAttribute("customers", customers);
		return "listCustomers";
	}

	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.GET)
	public String addCustomerGet(Model model) {
		Customer c = new Customer();

		model.addAttribute("customers", c);
		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.POST)
	public String addCustomerPost(@Valid @ModelAttribute("customers") Customer c, BindingResult result) {
		if (result.hasErrors()) {
			return "addCustomer";
		} else {
			cs.saveCustomer(c);
			return "redirect:showCustomers.html";
		}
	}

}
