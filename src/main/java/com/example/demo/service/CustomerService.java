package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
	List<Customer> getAllCustomer();
	void saveCustomer(Customer customer);
	
	Customer getCustomerById(long id);
	void deleteCustomerById(long id);
	boolean updateStatus(long id);



}
