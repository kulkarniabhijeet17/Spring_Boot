package com.springboot.example2.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example2.models.Customer;
import com.springboot.example2.models.Order;
import com.springboot.example2.services.CustomerService;
import com.springboot.example2.services.OrderService;

// Complex Example
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable String customerId) {
		return customerService.getCustomerDetail(customerId);
	}

	@GetMapping("/{customerId}/{orderId}")
	public Order getOrderById(@PathVariable final String customerId, @PathVariable final String orderId) {
		return orderService.getOrderByIdForCustomer(customerId, orderId);
	}

	@GetMapping(value = "/{customerId}/orders", produces = { "application/hal+json" })
	public CollectionModel<Order> getOrdersForCustomer(@PathVariable final String customerId) {
		final List<Order> orders = orderService.getAllOrdersForCustomer(customerId);
		for (final Order order : orders) {
			final Link selfLink = linkTo(
					methodOn(CustomerController.class).getOrderById(customerId, order.getOrderId())).withSelfRel();
			order.add(selfLink);
		}

		Link link = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId)).withSelfRel();
		CollectionModel<Order> result = CollectionModel.of(orders, link);

		return result;
	}

	@GetMapping(produces = { "application/hal+json" })
	public CollectionModel<Customer> getAllCustomers() {
		final List<Customer> allCustomers = customerService.allCustomers();

		for (final Customer customer : allCustomers) {
			String customerId = customer.getCustomerId();
			Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
			customer.add(selfLink);
			if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
				final Link ordersLink = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId))
						.withRel("allOrders");
				customer.add(ordersLink);
			}
		}

		Link link = linkTo(CustomerController.class).withSelfRel();
		CollectionModel<Customer> result = CollectionModel.of(allCustomers, link);

		return result;
	}
}