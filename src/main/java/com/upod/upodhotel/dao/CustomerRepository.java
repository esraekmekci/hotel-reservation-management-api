package com.upod.upodhotel.dao;

import com.upod.upodhotel.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByIdentityNumber(Long identityNumber);
}
