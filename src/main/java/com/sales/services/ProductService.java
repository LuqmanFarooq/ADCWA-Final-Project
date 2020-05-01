package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {
// Variables
	@Autowired
	ProductRepository pr;
// get all products method
	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) pr.findAll();
	}
// save product method
	public void saveProduct(Product p) {

		pr.save(p);
	}
// get one product method
	public Product getOneProduct(long id) {
		return pr.findOne(id);
	}
}
