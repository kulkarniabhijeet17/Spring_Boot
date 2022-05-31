package com.springboot.example2.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.example2.models.Customer;
import com.springboot.example2.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private HashMap<String, Customer> customerMap;

	public CustomerServiceImpl() {
		customerMap = new HashMap<>();

		final Customer customerOne = new Customer("C001", "Jane", "Ford Motors");
		final Customer customerTwo = new Customer("C002", "Bob", "Capgemini");
		final Customer customerThree = new Customer("C003", "Tim", "Microsoft Corporation");

		customerMap.put("C001", customerOne);
		customerMap.put("C002", customerTwo);
		customerMap.put("C003", customerThree);
	}

	@Override
	public List<Customer> allCustomers() {
		return new ArrayList<>(customerMap.values());
	}

	@Override
	public Customer getCustomerDetail(final String customerId) {
		return customerMap.get(customerId);
	}
}