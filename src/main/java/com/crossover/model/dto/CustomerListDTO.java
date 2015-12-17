package com.crossover.model.dto;

import java.io.Serializable;
import java.util.List;

public class CustomerListDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<CustomerDTO> customers;
	
	public CustomerListDTO(){}

	public CustomerListDTO(List<CustomerDTO> customers) {
		super();
		this.customers = customers;
	}

	public List<CustomerDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDTO> customers) {
		this.customers = customers;
	}
	
	

}
