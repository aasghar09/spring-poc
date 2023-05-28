package com.aliasghar.springpoc.service;

import com.aliasghar.springpoc.model.OrderEntity;


public interface OrderService {
	OrderEntity createOrder(OrderEntity orderEntity);
	OrderEntity getOrder(String orderNumber);
	void deleteOrder(OrderEntity orderEntity);
	OrderEntity update(OrderEntity orderEntity);
	
}
