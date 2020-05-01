package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {
// Variables
	@Autowired
	CustomerRepository cr;
// method to getall customers
	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) cr.findAll();
	}
// method to save customer
	public void saveCustomer(Customer c) {
		cr.save(c);
	}
// method to get one customer
	public Customer getOneCustomer(long id) {
		return cr.findOne(id);
	}
}
