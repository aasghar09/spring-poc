package com.aliasghar.springpoc.model;

import java.util.Date;
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
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name = "order_number",length = 20,nullable = false,unique = true)
	private String orderNumber;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "orderDetailsId")
	private Set<OrderDetailsEntity> orderDetailsEntities;

	
	public OrderEntity(Long orderId, String orderNumber, Date orderDate
										, Set<OrderDetailsEntity> orderDetailsEntities) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.orderDetailsEntities = orderDetailsEntities;
	}

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Set<OrderDetailsEntity> getOrderDetailsEntities() {
		return orderDetailsEntities;
	}

	public void setStockEntities(Set<OrderDetailsEntity> orderDetailsEntities) {
		this.orderDetailsEntities = orderDetailsEntities;
	}
	
	
	

}
