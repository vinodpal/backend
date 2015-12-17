package com.crossover;

import java.util.ArrayList;
import java.util.List;

import com.crossover.model.Customer;
import com.crossover.model.OrderLine;
import com.crossover.model.Product;
import com.crossover.model.SalesOrder;
import com.crossover.model.dto.CustomerDTO;
import com.crossover.model.dto.OrderLineDTO;
import com.crossover.model.dto.ProductDTO;
import com.crossover.model.dto.SalesOrderDTO;

public class Util {
	public static <E> List<E> toList(Iterable<E> iterable) {
		if (iterable instanceof List) {
			return (List<E>) iterable;
		}
		ArrayList<E> list = new ArrayList<E>();
		if (iterable != null) {
			for (E e : iterable) {
				list.add(e);
			}
		}
		return list;
	}
	
	
	public static CustomerDTO toCustomerDTO(Customer customer){
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setCode(customer.getCode());
		customerDto.setName(customer.getName());
		customerDto.setAddress(customer.getAddress());
		customerDto.setPhone1(customer.getPhone1());
		customerDto.setPhone2(customer.getPhone2());
		customerDto.setCreditLimit(customer.getCreditLimit());
		customerDto.setCurrentCredit(customer.getCurrentCredit());
		return customerDto;
		
	}
	
	public static Customer toCustomerEntity(CustomerDTO customerDto){
		
		Customer customer = new Customer();
		//new customer credit limit == currentcredit
		if(customerDto.getCode() == null){
			customer.setCurrentCredit(customerDto.getCreditLimit());
		}else{
			customer.setCode(customerDto.getCode());
			customer.setCurrentCredit(customerDto.getCurrentCredit());
		}
		customer.setName(customerDto.getName());
		customer.setAddress(customerDto.getAddress());
		customer.setPhone1(customerDto.getPhone1());
		customer.setPhone2(customerDto.getPhone2());
		customer.setCreditLimit(customerDto.getCreditLimit());
		return customer;
	}
	
	public static ProductDTO toProductDTO(Product product){
		ProductDTO productDto = new ProductDTO();
		
		productDto.setCode(product.getCode());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		productDto.setQuantity(product.getQuantity());
		
		return productDto;
	}
	
	public static Product toProductEntity(ProductDTO productDto){
		Product product = new Product();
		if(productDto.getCode() != null){
			product.setCode(productDto.getCode());
		}
		product.setDescription(productDto.getDescription());
		product.setQuantity(productDto.getQuantity());
		product.setPrice(productDto.getPrice());
		
		return product;
	}
	
	public static SalesOrderDTO toSalesOrderDTO(SalesOrder salesOrder){
		SalesOrderDTO salesOrderDto = new SalesOrderDTO();
		salesOrderDto.setOrderNumber(salesOrder.getOrderNumber());
		salesOrderDto.setTotalPrice(salesOrder.getTotalPrice());
		salesOrderDto.setCustomer(toCustomerDTO(salesOrder.getCustomer()));
		for (OrderLine orderLine : salesOrder.getOrderlines()) {
			salesOrderDto.getOrderLines().add(toOrderLineDTO(orderLine));
		}
		
		return salesOrderDto;
	}
	
	public static SalesOrder toSalesOrderEntity(SalesOrderDTO salesOrderDto){
		SalesOrder salesOrder = new SalesOrder();
		
		salesOrder.setOrderNumber(salesOrderDto.getOrderNumber());
		salesOrder.setTotalPrice(salesOrderDto.getTotalPrice());
		salesOrder.setCustomer(toCustomerEntity(salesOrderDto.getCustomer()));
		
		for (OrderLineDTO orderLineDto : salesOrderDto.getOrderLines()) {
			
			salesOrder.getOrderlines().add(toOrderLineEntity(orderLineDto));
		}
		for (OrderLine orderLine : salesOrder.getOrderlines()) {
			orderLine.setSalesOrder(salesOrder);
		}
		
		return salesOrder;
	}
	
	public static OrderLine toOrderLineEntity(OrderLineDTO orderLineDto){
		OrderLine orderLine = new OrderLine();
		orderLine.setQuantity(orderLineDto.getQuantity());
		orderLine.setUnitPrice(orderLineDto.getUnitPrice());
		orderLine.setTotalPrice(orderLineDto.getTotalPrice());
		orderLine.setProduct(toProductEntity(orderLineDto.getProductDTO()));
		return orderLine;
	}
	
	public static OrderLineDTO toOrderLineDTO(OrderLine orderLine){
		OrderLineDTO orderLineDto = new OrderLineDTO();
		orderLineDto.setQuantity(orderLine.getQuantity());
		orderLineDto.setProductDTO(toProductDTO(orderLine.getProduct()));
		orderLineDto.setId(orderLine.getId());
		orderLineDto.setTotalPrice(orderLine.getTotalPrice());
		orderLineDto.setUnitPrice(orderLine.getUnitPrice());
		return orderLineDto;
	}
}
