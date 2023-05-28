package com.aliasghar.springpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aliasghar.springpoc.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	OrderEntity findByOrderNumber(String orderNumber);

}
