package com.sales.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@SessionAttributes({ "customersList", "productList", "custo" })
@Controller
public class OrdersController {

	@Autowired
	OrderService os;

	@Autowired
	CustomerService cs;

	@Autowired
	ProductService ps;

	private Product prod;

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
	public String addOrderPost(@Valid @ModelAttribute("orders") Order o, BindingResult result) {

		prod = ps.getOneProduct(o.getProd().getpId());

		long qyiInStk;
		qyiInStk = o.getProd().getQtyInStock();
		if (result.hasErrors()) {
			return "newOrder";
		} else {
			if (o.getCust() == null) {
				return "errorPage2";
			} else if (o.getQty() > qyiInStk) {

				return "errorPage";
			} else {
				prod.setQtyInStock(prod.getQtyInStock() - (o.getQty()));
				os.saveOrder(o);

			}
		}
		return "redirect:showOrders.html";

	}

}
