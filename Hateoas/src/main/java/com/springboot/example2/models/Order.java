package com.springboot.example2.models;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;

// @Data
// @AllArgsConstructor
public class Order extends RepresentationModel<Order> {
	private String orderId;
	private double price;
	private int quantity;

	public Order() {
		super();
	}

	public Order(final String orderId, final double price, final int quantity) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}