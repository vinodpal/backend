package com.crossover.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.Util;
import com.crossover.model.Customer;
import com.crossover.model.OrderLine;
import com.crossover.model.Product;
import com.crossover.model.SalesOrder;
import com.crossover.model.dto.CustomerDTO;
import com.crossover.model.dto.CustomerListDTO;
import com.crossover.model.dto.OrderLineDTO;
import com.crossover.model.dto.ProductDTO;
import com.crossover.model.dto.ProductListDTO;
import com.crossover.model.dto.SalesOrderDTO;
import com.crossover.model.dto.SalesOrderListDTO;
import com.crossover.repository.CustomerRepository;
import com.crossover.repository.ProductRepository;
import com.crossover.repository.SalesOrderRepository;

@Component("salesService")
@Transactional
public class SalesServiceImpl implements SalesService{
	
	private CustomerRepository customerRepository;
	private ProductRepository productRepository;
	private SalesOrderRepository salesOrderRepository;
	
	@Autowired
	public SalesServiceImpl(CustomerRepository customerRepository, ProductRepository productRepository, SalesOrderRepository salesOrderRepository){
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
		this.salesOrderRepository = salesOrderRepository;
	}

	@Override
	public Integer deleteCustomer(Integer code) {
		Integer deleted = Integer.valueOf(0);
		try {
			customerRepository.delete(code);
			deleted = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

	@Override
	public Integer deleteProduct(Integer code) {
		Integer deleted = Integer.valueOf(0);
		try {
			productRepository.delete(code);	
			deleted = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

	@Override
	public ProductDTO addProduct(ProductDTO p) {
		Product persistedProduct = productRepository.save(Util.toProductEntity(p));
		return Util.toProductDTO(persistedProduct);
	}

	@Override
	public CustomerDTO addCustomer(CustomerDTO c) {

		Customer persistedCustomer = Util.toCustomerEntity(c);
		persistedCustomer = customerRepository.save(persistedCustomer);
		return Util.toCustomerDTO(persistedCustomer);
	}

	@Override
	public String validateSales(SalesOrderDTO salesOrderListDTO) {
		String response = "0";
		
		for (OrderLineDTO orderLine : salesOrderListDTO.getOrderLines()) {
			boolean quantityLessOrEqualInventory = orderLine.getProductDTO().getQuantity() <= orderLine.getQuantity();
			if(quantityLessOrEqualInventory){
				response = "1";
				return response;
			}
			
		}
		Double totalSalesPrice = salesOrderListDTO.getTotalPrice();
		boolean totalSalePriceLessOrEqualCurrent = totalSalesPrice >= salesOrderListDTO.getCustomer().getCreditLimit();
		boolean totalSalesPriceLessOrEqualLimit = totalSalesPrice >= salesOrderListDTO.getCustomer().getCurrentCredit();
		if(totalSalePriceLessOrEqualCurrent || totalSalesPriceLessOrEqualLimit){
			response = "2";
		}
		
		return response;
	}

	@Override
	public SalesOrderDTO addSalesOrderWithOrderLines(SalesOrderDTO salesOrderDTO) {
		SalesOrder persistedSalesOrder = Util.toSalesOrderEntity(salesOrderDTO);
//		update user current credit
		Customer updateCustomer = persistedSalesOrder.getCustomer();
		Double totalSalePrice = salesOrderDTO.getTotalPrice();
		updateCustomerCredit(updateCustomer, totalSalePrice);
		for (OrderLine orderLine : persistedSalesOrder.getOrderlines()) {
			Product product = orderLine.getProduct();
			Integer quantity = orderLine.getQuantity();
			updateProductQuantities(product, quantity);
		} 
		SalesOrderDTO response = Util.toSalesOrderDTO(salesOrderRepository.save(persistedSalesOrder));
		return response;
	}
	
	@Override
	public Integer deleteSales(String code) {
		Integer deleted = Integer.valueOf(0);
		SalesOrder salesOrder = salesOrderRepository.findOne(code);
		resetCreditAndQuantity(salesOrder);
		try {
			salesOrderRepository.delete(code);	
			deleted = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
	
	private void resetCreditAndQuantity(SalesOrder salesOrder){
		Double totalPrice = salesOrder.getTotalPrice();
//		Update the quantity of the product
		for (OrderLine orderLine : salesOrder.getOrderlines()) {
			Product product = orderLine.getProduct();
			Integer quantity = orderLine.getQuantity();
			Integer currentQuantity = orderLine.getProduct().getQuantity();
			Integer newQuantity = currentQuantity + quantity;
			product.setQuantity(newQuantity);
		}
//		update the credit limit
		Customer customer = salesOrder.getCustomer();
		Double currentCreditLimit = customer.getCurrentCredit();
		Double newCurrentCredito = currentCreditLimit + totalPrice;
		customer.setCurrentCredit(newCurrentCredito);
	}
	
	private void updateCustomerCredit(Customer customer, Double totalPrice){
		Customer persistedCustomer = customerRepository.findOne(customer.getCode());
		if(customer != null && totalPrice != null){
			Double currentCredit = persistedCustomer.getCurrentCredit();
			Double newCurrentCredit = currentCredit - totalPrice;
			customer.setCurrentCredit(newCurrentCredit);
			customerRepository.save(customer);
		}
	}
	
	private void updateProductQuantities(Product product, Integer quantity){
		if(product != null && quantity != null){
			Integer currentQuantity = product.getQuantity();
			Integer newQuantity = currentQuantity - quantity;
			product.setQuantity(newQuantity);
		}
			
	}

	@Override
	@Transactional(readOnly=true)
	public CustomerListDTO findAllCustomer() {
		
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		
		List<Customer> customerEntities = Util.toList(customerRepository.findAll());
		
		
		for (Customer c : customerEntities) {
			customers.add(Util.toCustomerDTO(c));
		}
		
		return new CustomerListDTO(customers);
	}

	@Override
	@Transactional(readOnly=true)
	public ProductListDTO findAllProducts() {
		List<ProductDTO> productsDto = new ArrayList<ProductDTO>();
		
		List<Product> products = Util.toList(productRepository.findAll());
		
		for (Product product : products) {
			productsDto.add(Util.toProductDTO(product));
		}
		
		return new ProductListDTO(productsDto);
	}

	@Override
	@Transactional(readOnly=true)
	public SalesOrderListDTO findAllSalesOrder() {
		List<SalesOrderDTO> salesOrderDto = new ArrayList<SalesOrderDTO>();
		
		List<SalesOrder> salesOrders = Util.toList(salesOrderRepository.findAll());
		
		for (SalesOrder salesOrder : salesOrders) {
			salesOrderDto.add(Util.toSalesOrderDTO(salesOrder));
		}
		
		return new SalesOrderListDTO(salesOrderDto);
	}

	@Override
	public CustomerDTO findCustomerByCode(Integer code) {
		CustomerDTO customerDTO = Util.toCustomerDTO(customerRepository.findOne(code));
		return customerDTO;
	}

	@Override
	public ProductDTO findProductByCode(Integer code) {
		ProductDTO productDTO = Util.toProductDTO(productRepository.findOne(code));
		return productDTO;
	}

	@Override
	public SalesOrderDTO findSalesOrderByCode(String code) {
		SalesOrderDTO salesOrderDTO = Util.toSalesOrderDTO(salesOrderRepository.findOne(code));
		return salesOrderDTO;
	}
}
