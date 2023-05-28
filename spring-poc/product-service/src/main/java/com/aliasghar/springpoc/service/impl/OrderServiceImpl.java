package com.aliasghar.springpoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliasghar.springpoc.model.OrderEntity;
import com.aliasghar.springpoc.repository.OrderRepository;
import com.aliasghar.springpoc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(rollbackFor = Exception.class)
	public OrderEntity createOrder(OrderEntity orderEntity) {
		return orderRepository.save(orderEntity);

	}

	@Override
	public OrderEntity getOrder(String orderNumber) {
		
		OrderEntity orderEntity =orderRepository.findByOrderNumber(orderNumber);
		
		return orderEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteOrder(OrderEntity orderEntity) {
		orderRepository.delete(orderEntity);
		
	}

	@Transactional
	public OrderEntity update(OrderEntity orderEntity) {
		
		return orderRepository.save(orderEntity);
	}

}
