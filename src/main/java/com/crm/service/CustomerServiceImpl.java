package com.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.beans.Customer;
import com.crm.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		customerRepository.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		return customerRepository.findById(theId).orElse(null);
	}

	@Override
	public void deleteCustomer(int theId) {
		
		customerRepository.deleteById(theId);
	}
}





