package com.crossover.repository;

import org.springframework.data.repository.CrudRepository;

import com.crossover.model.SalesOrder;

public interface SalesOrderRepository extends
		CrudRepository<SalesOrder, String> {

}
