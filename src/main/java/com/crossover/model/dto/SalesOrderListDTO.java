package com.crossover.model.dto;

import java.io.Serializable;
import java.util.List;

public class SalesOrderListDTO implements Serializable{
	
	private static final long serialVersionUID = 726886597953115690L;
	private List<SalesOrderDTO> salesOrder;
	
	public SalesOrderListDTO(){}

	public SalesOrderListDTO(List<SalesOrderDTO> salesOrder) {
		super();
		this.salesOrder = salesOrder;
	}

	public List<SalesOrderDTO> getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(List<SalesOrderDTO> salesOrder) {
		this.salesOrder = salesOrder;
	}

}
