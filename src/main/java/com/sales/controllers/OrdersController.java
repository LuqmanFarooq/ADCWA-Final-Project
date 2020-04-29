package com.sales.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrdersController {

	@Autowired
	OrderService os;

	@Autowired
	CustomerService cs;

	@Autowired
	ProductService ps;

	@RequestMapping(value = "/showOrders.html")
	public String getOrders(Model model) {
		ArrayList<Order> orders = os.getAllOrders();
		model.addAttribute("orders", orders);
		return "listOrders";
	}

	@RequestMapping(value = "/newOrder.html", method = RequestMethod.GET)
	public String addOrderGet(Model model) {
		// getting customer names and storing in map
		ArrayList<Customer> customers = cs.getAllCustomers();
		Map<Long, String> customersList = new LinkedHashMap<Long, String>();
		for (Customer c : customers) {
			customersList.put(c.getcId(), c.getcName());
		}
		model.addAttribute("customersList", customersList);

		// getting product names and storing in map
		ArrayList<Product> products = ps.getAllProducts();
		Map<Long, String> productList = new LinkedHashMap<Long, String>();
		for (Product c : products) {
			productList.put(c.getpId(), c.getpDesc());
		}
		model.addAttribute("productList", productList);
		
		Order o = new Order();
		
		model.addAttribute("orders", o);
		return "newOrder";
	}

	@RequestMapping(value = "/newOrder.html", method = RequestMethod.POST)
	public String addOrderPost(@ModelAttribute("orders") Order o) {
		os.saveOrder(o);
		return "redirect:showOrders.html";
	}

}
