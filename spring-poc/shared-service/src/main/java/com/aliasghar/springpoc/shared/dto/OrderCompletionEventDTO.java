package com.aliasghar.springpoc.shared.dto;

import java.io.Serializable;

public class OrderCompletionEventDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6143110764989061549L;
	private String orderNumber;
	private String email;
	
	public OrderCompletionEventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderCompletionEventDTO(String orderNumber, String email) {
		super();
		this.orderNumber = orderNumber;
		this.email = email;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	
	

}
