package com.crossover.repository;

import org.springframework.data.repository.CrudRepository;

import com.crossover.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
