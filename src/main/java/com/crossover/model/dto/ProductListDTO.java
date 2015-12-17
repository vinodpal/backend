package com.crossover.model.dto;

import java.io.Serializable;
import java.util.List;

public class ProductListDTO implements Serializable {

	private static final long serialVersionUID = 6803560629109873285L;
	private List<ProductDTO> products;
	
	public ProductListDTO(){
		
	}

	public ProductListDTO(List<ProductDTO> products) {
		super();
		this.products = products;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	

}
