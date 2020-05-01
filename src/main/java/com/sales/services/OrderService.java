package com.sales.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderRepository;

@Service
public class OrderService {
// Variables
	@Autowired
	OrderRepository or;
// getting all orders method
	public ArrayList<Order> getAllOrders() {
		return (ArrayList<Order>) or.findAll();
	}
// save order method
	public void saveOrder(Order o) {
// saving current date with order
		LocalDate dt = LocalDate.now();
		o.setOrderDate(String.valueOf(dt.getYear()) + "-" + String.valueOf(dt.getMonthValue()) + "-"
				+ String.valueOf(dt.getDayOfMonth()));
		or.save(o);
	}
}
