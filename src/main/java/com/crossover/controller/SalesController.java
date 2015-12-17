package com.crossover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.model.dto.CustomerDTO;
import com.crossover.model.dto.CustomerListDTO;
import com.crossover.model.dto.ProductDTO;
import com.crossover.model.dto.ProductListDTO;
import com.crossover.model.dto.SalesOrderDTO;
import com.crossover.model.dto.SalesOrderListDTO;
import com.crossover.service.SalesService;

@RestController()
public class SalesController {
	
	private SalesService salesService;
	
	
	@Autowired
	public SalesController(SalesService salesService){
		this.salesService = salesService;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/product/new", consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ProductDTO addProduct(@RequestBody ProductDTO p){
		return salesService.addProduct(p);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sales/new", consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public SalesOrderDTO addSalesOrder(@RequestBody SalesOrderDTO p){
		return salesService.addSalesOrderWithOrderLines(p);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sales/validate", consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces=MediaType.TEXT_PLAIN_VALUE)
	public String validateSalesOrder(@RequestBody SalesOrderDTO p){
		return salesService.validateSales(p);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customer/new", consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public CustomerDTO addCustomer(@RequestBody CustomerDTO c){
		return salesService.addCustomer(c);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/product/{productCode}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ProductDTO findProductByCode(@PathVariable("productCode") String code){
		return salesService.findProductByCode(Integer.valueOf(code));
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer", produces={MediaType.APPLICATION_JSON_VALUE})
	public CustomerListDTO findProduct(){
		return salesService.findAllCustomer();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/product", produces={MediaType.APPLICATION_JSON_VALUE})
	public ProductListDTO findCustomer(){
		return salesService.findAllProducts();
	}

	@RequestMapping(method=RequestMethod.GET, value="/customer/{customerCode}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public CustomerDTO findOneCustomerByCode(@PathVariable("customerCode") String code){
		return salesService.findCustomerByCode(Integer.valueOf(code));
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/product/{productCode}/delete", produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleteProduct(@PathVariable("productCode")String code){
		return salesService.deleteProduct(Integer.valueOf(code)).toString();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/{customerCode}/delete", produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleteCustomer(@PathVariable("customerCode")String code){
		return salesService.deleteCustomer(Integer.valueOf(code)).toString();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sales/{orderNumber}/delete", produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleteSales(@PathVariable("orderNumber")String code){
		return salesService.deleteSales(code).toString();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sales", produces={MediaType.APPLICATION_JSON_VALUE})
	public SalesOrderListDTO findAllSalesOrder(){
		return salesService.findAllSalesOrder();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sales/{orderNumber}", produces={MediaType.APPLICATION_JSON_VALUE})
	public SalesOrderDTO findSalesOrderByCode(@PathVariable(value="orderNumber") String code){
		return salesService.findSalesOrderByCode(code);
	}
	
	@ExceptionHandler()
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleUserAlreadyExistsException(Exception e) {
	    return e.getMessage();
	}
	
	
}
