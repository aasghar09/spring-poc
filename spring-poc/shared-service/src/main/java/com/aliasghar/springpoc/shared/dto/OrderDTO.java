package com.aliasghar.springpoc.shared.dto;

import java.util.Date;
import java.util.Set;



public class OrderDTO {
	
	private String orderNumber;
	private Date orderDate;
	private Set<StockDTO> stockDTO;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(String orderNumber, Date orderDate, Set<StockDTO> stockDTO) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.stockDTO = stockDTO;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Set<StockDTO> getStockDTO() {
		return stockDTO;
	}
	public void setStockDTO(Set<StockDTO> stockDTO) {
		this.stockDTO = stockDTO;
	}
	
	
}
