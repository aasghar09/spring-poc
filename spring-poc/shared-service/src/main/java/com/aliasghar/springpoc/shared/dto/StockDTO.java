package com.aliasghar.springpoc.shared.dto;

import java.math.BigDecimal;
import java.util.Date;



public class StockDTO {
	
	
	private String stockCode;
	private BigDecimal purchasePrice;
	private Date expiryDate;
	private Date sellingDate;
	private String comments;
	private String productCode;
	private boolean isSold;
	
	public StockDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StockDTO(String stockCode, BigDecimal purchasePrice, Date expiryDate
			, Date sellingDate, String comments,
			String productCode) {
		super();
		this.stockCode = stockCode;
		this.purchasePrice = purchasePrice;
		this.expiryDate = expiryDate;
		this.sellingDate = sellingDate;
		this.comments = comments;
		this.productCode = productCode;
	}


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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	
	

}
