package com.springboot.example2.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.example2.models.Customer;
import com.springboot.example2.models.Order;
import com.springboot.example2.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	private HashMap<String, Customer> customerMap;
	private HashMap<String, Order> customerOneOrderMap;
	private HashMap<String, Order> customerTwoOrderMap;
	private HashMap<String, Order> customerThreeOrderMap;

	public OrderServiceImpl() {
		customerMap = new HashMap<>();
		customerOneOrderMap = new HashMap<>();
		customerTwoOrderMap = new HashMap<>();
		customerThreeOrderMap = new HashMap<>();

		customerOneOrderMap.put("O-001A", new Order("O-001A", 150.00, 25));
		customerOneOrderMap.put("O-002A", new Order("O-002A", 250.00, 15));

		customerTwoOrderMap.put("O-002B", new Order("O-002B", 550.00, 325));
		customerTwoOrderMap.put("O-002B", new Order("O-002B", 450.00, 525));

		final Customer customerOne = new Customer("C001", "Jane", "Ford Motors");
		final Customer customerTwo = new Customer("C002", "Bob", "Capgemini");
		final Customer customerThree = new Customer("C003", "Tim", "Microsoft Corporation");

		customerOne.setOrders(customerOneOrderMap);
		customerTwo.setOrders(customerTwoOrderMap);
		customerThree.setOrders(customerThreeOrderMap);

		customerMap.put("C001", customerOne);
		customerMap.put("C002", customerTwo);
		customerMap.put("C003", customerThree);
	}

	@Override
	public List<Order> getAllOrdersForCustomer(final String customerId) {
		return new ArrayList<>(customerMap.get(customerId).getOrders().values());
	}

	@Override
	public Order getOrderByIdForCustomer(final String customerId, final String orderId) {
		final Map<String, Order> orders = customerMap.get(customerId).getOrders();
		Order selectedOrder = orders.get(orderId);
		return selectedOrder;
	}
}