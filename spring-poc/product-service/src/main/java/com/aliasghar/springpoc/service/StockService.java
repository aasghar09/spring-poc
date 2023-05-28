package com.aliasghar.springpoc.service;

import com.aliasghar.springpoc.model.StockEntity;

public interface StockService {
	void createStock(StockEntity stockEntity);
	void updateStock(StockEntity stockEntity);
	StockEntity findByStockCode(String stockCode);
	

}
