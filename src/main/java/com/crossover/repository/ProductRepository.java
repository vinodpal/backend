package com.crossover.repository;

import org.springframework.data.repository.CrudRepository;

import com.crossover.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
