package com.aliasghar.springpoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliasghar.springpoc.model.StockEntity;
import com.aliasghar.springpoc.repository.StockRepository;
import com.aliasghar.springpoc.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Transactional
	public void createStock(StockEntity stockEntity) {
		stockRepository.save(stockEntity);
	}

	@Transactional
	public void updateStock(StockEntity stockEntity) {
		stockRepository.save(stockEntity);

	}
	
	public StockEntity findByStockCode(String stockCode) {
		return stockRepository.findByStockCode(stockCode);

	}

}
