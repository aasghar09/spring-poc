package com.aliasghar.springpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aliasghar.springpoc.model.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
	
	StockEntity findByStockCode(String stockCode);

}
