package com.crossover.model.dto;

import java.io.Serializable;

public class OrderLineDTO implements Serializable {
	


	private static final long serialVersionUID = -6791740624337405684L;
	private Integer id;
	private ProductDTO productDTO;
	private Integer quantity;
	private Double unitPrice;
	private Double totalPrice;
	
	
	public OrderLineDTO(){}


	public OrderLineDTO(Integer id, ProductDTO productDTO, Integer quantity,
			Double unitPrice, Double totalPrice) {
		super();
		this.id = id;
		this.productDTO = productDTO;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public ProductDTO getProductDTO() {
		return productDTO;
	}


	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((productDTO == null) ? 0 : productDTO.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result
				+ ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result
				+ ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		OrderLineDTO other = (OrderLineDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productDTO == null) {
			if (other.productDTO != null)
				return false;
		} else if (!productDTO.equals(other.productDTO))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "OrderLineDTO [id=" + id + ", productDTO=" + productDTO.toString()
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", totalPrice=" + totalPrice + "]";
	}


}
