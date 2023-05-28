package com.aliasghar.springpoc.shared.dto;

import java.math.BigDecimal;



public class ProductDTO {

	private String productCode;
	
	private String productName;
	
	private BigDecimal price;
	
	private String description;
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductDTO(String productCode, String productName, BigDecimal price, String description) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.description = description;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
