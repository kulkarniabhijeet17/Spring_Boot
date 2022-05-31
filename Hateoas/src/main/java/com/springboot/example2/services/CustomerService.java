package com.springboot.example2.services;

import java.util.List;

import com.springboot.example2.models.Customer;

public interface CustomerService {
	List<Customer> allCustomers();

	Customer getCustomerDetail(final String id);
}