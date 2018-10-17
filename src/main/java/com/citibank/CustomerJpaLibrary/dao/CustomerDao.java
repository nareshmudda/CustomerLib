package com.citibank.CustomerJpaLibrary.dao;

import com.citibank.CustomerJpaLibrary.Entity.Customer;

public interface CustomerDao {

	Customer loadCustomer(Long id);

	Customer saveCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	boolean deleteCustomer(Long id);
	
	Customer loadCustomerWithOrders(Long id);
	
}
