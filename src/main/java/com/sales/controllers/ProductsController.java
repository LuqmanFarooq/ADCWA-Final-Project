package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductsController {

	@Autowired
	ProductService ps;
	
	@RequestMapping(value = "/showProducts.html")
	public String getProducts(Model model) {
		ArrayList<Product> products =  ps.getAllProducts();
		model.addAttribute("products", products);
		return "listProducts";
	}
	
	@RequestMapping(value = "/addProduct.html" , method = RequestMethod.GET)
	public String addProductGet(Model model) {
		Product p = new Product();
		
		model.addAttribute("products", p);
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct.html" , method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("products") Product p) {
		ps.saveProduct(p);
		return "redirect:showProducts.html";
	}
	
}
