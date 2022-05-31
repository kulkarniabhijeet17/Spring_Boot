package com.springboot.example2.models;

import java.util.Map;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

// @Data
// @AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Customer extends RepresentationModel<Customer> {
	private String customerId;
	private String customerName;
	private String companyName;
	private Map<String, Order> orders;

	public Customer() {
		super();
	}

	public Customer(final String customerId, final String customerName, final String companyName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.companyName = companyName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Map<String, Order> getOrders() {
		return orders;
	}

	public void setOrders(Map<String, Order> orders) {
		this.orders = orders;
	}
}