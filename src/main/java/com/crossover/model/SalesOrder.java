package com.crossover.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="salesorder")
public class SalesOrder implements Serializable {

	private static final long serialVersionUID = -3744988808750982025L;
	@Id
	private String orderNumber;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="customer")
	private Customer customer;
	private Double totalPrice;
	@OneToMany(mappedBy="salesOrder", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<OrderLine> orderlines = new HashSet<OrderLine>(0);
	 
	
	public SalesOrder(){}

	public SalesOrder(String orderNumber, Customer customer, Double totalPrice) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Set<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(Set<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

	
		

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result
				+ ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result
				+ ((orderlines == null) ? 0 : orderlines.hashCode());
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
		SalesOrder other = (SalesOrder) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (orderlines == null) {
			if (other.orderlines != null)
				return false;
		} else if (!orderlines.equals(other.orderlines))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder()
		.append("SalesOrder [orderNumber= ").append(orderNumber)
		.append(", customer= ").append(customer)
		.append(", totalPrice= ").append(totalPrice);
		
		return sb.toString();
	}

}
