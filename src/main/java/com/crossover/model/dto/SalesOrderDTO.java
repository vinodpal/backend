package com.crossover.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalesOrderDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private String orderNumber;
	private CustomerDTO customer;
	private Double totalPrice;
	private List<OrderLineDTO> orderLines = new ArrayList<OrderLineDTO>();
	
	public SalesOrderDTO(){}

	public SalesOrderDTO(String orderNumber, CustomerDTO customer,
			Double totalPrice) {
		super();
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.totalPrice = totalPrice;
	}
	

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public List<OrderLineDTO> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLineDTO> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result
				+ ((orderLines == null) ? 0 : orderLines.hashCode());
		result = prime * result
				+ ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result
				+ ((totalPrice == null) ? 0 : totalPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrderDTO other = (SalesOrderDTO) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderLines == null) {
			if (other.orderLines != null)
				return false;
		} else if (!orderLines.equals(other.orderLines))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesOrderDTO [orderNumber=" + orderNumber + ", customer="
				+ customer + ", totalPrice=" + totalPrice + ", orderLines="
				+ orderLines.toString() + "]";
	}
	
	

}
