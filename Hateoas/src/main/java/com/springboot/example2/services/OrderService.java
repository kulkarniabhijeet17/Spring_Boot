package com.springboot.example2.services;

import java.util.List;

import com.springboot.example2.models.Order;

public interface OrderService {
	List<Order> getAllOrdersForCustomer(String customerId);

	Order getOrderByIdForCustomer(String customerId, String orderId);
}