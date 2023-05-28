package com.aliasghar.springpoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aliasghar.springpoc.model.ProductEntity;
import com.aliasghar.springpoc.repository.ProductRepository;
import com.aliasghar.springpoc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public void createProduct(ProductEntity productEntity) {
		productRepository.save(productEntity);
	}

	@Transactional
	public void updateProduct(ProductEntity entity) {
		// TODO Auto-generated method stub
		productRepository.save(entity);
	}

	@Override
	public ProductEntity findByProductCode(String productCode) {
		ProductEntity productEntity =productRepository.findByProductCode(productCode);
		
		return productEntity;

	}

}
