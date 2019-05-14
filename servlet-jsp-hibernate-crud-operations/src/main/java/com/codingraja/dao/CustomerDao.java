package com.codingraja.dao;

import java.util.List;

import com.codingraja.domain.Customer;

public interface CustomerDao {
	Long saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);

	Customer findCustomerById(Long id);

	List<Customer> findAllCustomers();
}
