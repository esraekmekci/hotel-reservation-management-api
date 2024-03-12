package com.upod.upodhotel.services.impl;

import com.upod.upodhotel.dao.CustomerRepository;
import com.upod.upodhotel.entities.Customer;
import com.upod.upodhotel.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer newCustomer) {
        if (customerRepository.findByIdentityNumber(newCustomer.getIdentityNumber()) != null) {
            return null;
        }
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            Customer foundCustomer = customer.get();
            foundCustomer.setName(updatedCustomer.getName());
            foundCustomer.setSurname(updatedCustomer.getSurname());
            foundCustomer.setPhone(updatedCustomer.getPhone());
            foundCustomer.setBirthdate(updatedCustomer.getBirthdate());
            foundCustomer.setIdentityNumber(updatedCustomer.getIdentityNumber());
            customerRepository.save(foundCustomer);
            return foundCustomer;
        } else {
            return null;
        }
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
