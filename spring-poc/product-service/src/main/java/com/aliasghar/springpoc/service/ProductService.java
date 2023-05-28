package com.aliasghar.springpoc.service;


import com.aliasghar.springpoc.model.ProductEntity;

public interface ProductService {
	void createProduct(ProductEntity productEntity);
	void updateProduct(ProductEntity productEntity);
	ProductEntity findByProductCode(String productCode);
}
