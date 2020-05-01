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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductsController {
// variables
	@Autowired
	ProductService ps;
// getting all products and displaying them
	@RequestMapping(value = "/showProducts.html")
	public String getProducts(Model model) {
		ArrayList<Product> products = ps.getAllProducts();
		model.addAttribute("products", products);
		return "listProducts";
	}
// add product page get request
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.GET)
	public String addProductGet(Model model) {
		Product p = new Product();

		model.addAttribute("products", p);
		return "addProduct";
	}
	// post request to submit form data
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("products") Product p, BindingResult result) {
		// if errors validation
		if (result.hasErrors()) {
			return "addProduct";
		} else {
			// saving product
			ps.saveProduct(p);
			return "redirect:showProducts.html";
		}

	}

}
