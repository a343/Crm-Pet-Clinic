package com.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
