package com.aliasghar.springpoc.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDetailsId;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="orderId")
	private OrderEntity orderEntity;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="stockId")
	private StockEntity stockEntity;
	
	

	public OrderDetailsEntity(Long orderDetailsId, OrderEntity orderEntity, StockEntity stockEntity) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.orderEntity = orderEntity;
		this.stockEntity = stockEntity;
	}

	public OrderDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public StockEntity getStockEntity() {
		return stockEntity;
	}

	public void setStockEntity(StockEntity stockEntity) {
		this.stockEntity = stockEntity;
	}
	
	
	
}
