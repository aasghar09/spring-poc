package com.aliasghar.springpoc.model;

import java.math.BigDecimal;
import java.util.Date;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "stocks")
public class StockEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;
	
	@Column(name = "stock_code",length = 20,unique = true,nullable = false)
	private String stockCode;
	
	@Column(name = "purchase_price")
	private BigDecimal purchasePrice;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name="selling-date")
	private Date sellingDate;
	
	@Column(name="comments",length = 60)
	private String comments;
	
	@Column(name="is_sold",length = 1)
	private boolean isSold;
	
	@JoinColumn(name = "id")
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	//@JsonIgnore
	private ProductEntity productEntity;
	

	
	
	public StockEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockEntity(Long stockId, String stockCode, BigDecimal purchasePrice, Date expiryDate, Date sellingDate,
			String comments, ProductEntity productEntity) {
		super();
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.purchasePrice = purchasePrice;
		this.expiryDate = expiryDate;
		this.sellingDate = sellingDate;
		this.comments = comments;
		this.productEntity = productEntity;
	}

	public Long getStockId() {
		return stockId;
	}

	/*public void setStockId(Long stockId) {
		this.stockId = stockId;
	}*/

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getSellingDate() {
		return sellingDate;
	}

	public void setSellingDate(Date sellingDate) {
		this.sellingDate = sellingDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	
	
	
	
}
