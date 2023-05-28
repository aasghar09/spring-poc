package com.aliasghar.springpoc.model;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "product_code",unique = true, length = 20,nullable = false)
	private String productCode;
	
	@Column(name = "product_name",length = 60,nullable = true)
	private String productName;
	
	@Column(name = "price",nullable = false)
	private BigDecimal price;
	
	@Column(name = "description",length = 60)
	private String description;
	
	@Column(name = "is_active")
	private String isActive;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productEntity")
	private Set<StockEntity> stockSet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(Long id, String productCode, String productName, BigDecimal price, String description,String isAtive) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.isActive = isAtive;
	}
	
	
	
}
