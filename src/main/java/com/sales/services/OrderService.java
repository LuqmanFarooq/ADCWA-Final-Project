package com.sales.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.OrderRepository;
import com.sales.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository or;

	public ArrayList<Order> getAllOrders() {
		return (ArrayList<Order>) or.findAll();
	}

	public void saveOrder(Order o) {

		LocalDate dt = LocalDate.now();
		o.setOrderDate(String.valueOf(dt.getYear()) + "-" + String.valueOf(dt.getMonthValue()) + "-"
				+ String.valueOf(dt.getDayOfMonth()));
		or.save(o);
	}
}
