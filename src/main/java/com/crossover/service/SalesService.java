package com.crossover.service;

import com.crossover.model.dto.CustomerDTO;
import com.crossover.model.dto.CustomerListDTO;
import com.crossover.model.dto.ProductDTO;
import com.crossover.model.dto.ProductListDTO;
import com.crossover.model.dto.SalesOrderDTO;
import com.crossover.model.dto.SalesOrderListDTO;

public interface SalesService {
	
	
	public Integer deleteCustomer(Integer code);
	public Integer deleteProduct(Integer code);
	public Integer deleteSales(String code);
	
	public ProductDTO addProduct(ProductDTO p);
	public CustomerDTO addCustomer(CustomerDTO c);
	public String validateSales(SalesOrderDTO salesOrderList);
	public SalesOrderDTO addSalesOrderWithOrderLines(SalesOrderDTO salesOrderListDTO);
	public CustomerListDTO findAllCustomer();
	public ProductListDTO findAllProducts();
	public SalesOrderListDTO findAllSalesOrder();
	public CustomerDTO findCustomerByCode(Integer code);
	public ProductDTO findProductByCode(Integer code);
	public SalesOrderDTO findSalesOrderByCode(String code);

}

