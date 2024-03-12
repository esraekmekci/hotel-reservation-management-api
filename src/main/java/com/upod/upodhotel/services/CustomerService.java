package com.upod.upodhotel.services;

import com.upod.upodhotel.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    Customer saveCustomer(Customer newCustomer);

    Customer updateCustomer(Long customerId, Customer updatedCustomer);

    void deleteCustomer(Long customerId);
}
