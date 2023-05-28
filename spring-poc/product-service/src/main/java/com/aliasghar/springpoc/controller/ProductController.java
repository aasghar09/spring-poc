package com.aliasghar.springpoc.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aliasghar.springpoc.model.OrderDetailsEntity;
import com.aliasghar.springpoc.model.OrderEntity;
import com.aliasghar.springpoc.model.ProductEntity;
import com.aliasghar.springpoc.model.StockEntity;
import com.aliasghar.springpoc.service.OrderService;
import com.aliasghar.springpoc.service.ProductService;
import com.aliasghar.springpoc.service.StockService;
import com.aliasghar.springpoc.shared.dto.OrderCompletionEventDTO;
import com.aliasghar.springpoc.shared.dto.OrderDTO;
import com.aliasghar.springpoc.shared.dto.ProductDTO;
import com.aliasghar.springpoc.shared.dto.StockDTO;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	StockService stockService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	private KafkaTemplate<String, OrderCompletionEventDTO> kafkaTemplate;
	
	@RequestMapping(path = "/createProduct",method = RequestMethod.POST)
	public void createProduct(@RequestBody ProductDTO productDTO)
	{
		ProductEntity entity =  productService.findByProductCode(productDTO.getProductCode());
		//ProductEntity entity =null;
		if(entity == null) {
			entity = new ProductEntity();
			entity.setProductCode(productDTO.getProductCode() );
			entity.setProductName(productDTO.getProductName());
			entity.setPrice(productDTO.getPrice());
			entity.setDescription(productDTO.getDescription());
			entity.setIsActive("Y");
			
			productService.createProduct(entity);
		}
	}
	
	
	@RequestMapping(path = "/updateProduct",method = RequestMethod.POST)
	public void updateProduct(@RequestBody ProductDTO productDTO)
	{
		ProductEntity entity =  productService.findByProductCode(productDTO.getProductCode());
		//ProductEntity entity =null;
		if(entity != null) {
			entity.setProductName(productDTO.getProductName());
			entity.setPrice(productDTO.getPrice());
			entity.setDescription(productDTO.getDescription());
			entity.setIsActive("Y");
			
			productService.updateProduct(entity);
		}
	}
	
	@RequestMapping(path = "/createStock",method =RequestMethod.POST)
	public void createStock(@RequestBody StockDTO stockdto) 
	{
		StockEntity stockEntity = null;
		
		ProductEntity productEntity = productService
										.findByProductCode(stockdto.getProductCode());
		
		if(productEntity != null) {
			stockEntity = new StockEntity();
			stockEntity.setStockCode(stockdto.getStockCode());
			stockEntity.setPurchasePrice(stockdto.getPurchasePrice());
			stockEntity.setSold(Boolean.FALSE);
			stockEntity.setSellingDate(null);
			stockEntity.setExpiryDate(new Date());
			stockEntity.setComments(stockdto.getComments());
			stockEntity.setProductEntity(productEntity);
			stockService.createStock(stockEntity);
			
		}
		
		return;
	}
	
	@RequestMapping(path = "/placeOrder",method =RequestMethod.POST)
	@Transactional(rollbackFor = Exception.class)
	public String placeOrder(@RequestBody OrderDTO orderdto) throws Exception 
	{
		
		if(orderdto != null && orderdto.getStockDTO().size() > 0)
		{
			OrderEntity orderEntity =orderService.getOrder(orderdto.getOrderNumber());
			
			if (orderEntity == null)
			{
				orderEntity = new OrderEntity();
				orderEntity.setOrderNumber(orderdto.getOrderNumber());
				orderEntity.setOrderDate(new Date());
				orderEntity = orderService.createOrder(orderEntity);
				
				Set<StockDTO> stocksSet =  orderdto.getStockDTO();
				
				Set<OrderDetailsEntity> orderDetailsSet = new HashSet<>();
				
				//TODO--> change this to java streams
				Iterator<StockDTO> stockIterator = stocksSet.iterator();
				while(stockIterator.hasNext())
				{
					StockDTO stockDTO = stockIterator.next();
					
					StockEntity stockEntity = stockService
												.findByStockCode(stockDTO.getStockCode());
					
					if(stockEntity == null) {
						throw new Exception("Stock Not Defined");
						//orderService.deleteOrder(orderEntity);
						//return "Stock Code"+stockDTO.getStockCode()+" Not Found";
					}else {
						stockEntity.setSold(Boolean.TRUE);
					}
						
					OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
					orderDetailsEntity.setOrderEntity(orderEntity);
					orderDetailsEntity.setStockEntity(stockEntity);
					
					orderDetailsSet.add(orderDetailsEntity);
					
				}
				
				if (orderDetailsSet != null && orderDetailsSet.size() > 0) {
					orderEntity.setStockEntities(orderDetailsSet);
					OrderCompletionEventDTO orderCompletionEventDTO = new OrderCompletionEventDTO();
					orderCompletionEventDTO.setEmail(null);
					orderCompletionEventDTO.setOrderNumber(orderEntity.getOrderNumber());
					orderService.update(orderEntity);
					kafkaTemplate.send("orderCompletionNotification", orderCompletionEventDTO);
					return "Order Placed Succesfully";
				}else {
					return "Stock not exist";
				}
				
			}
			return "Order not exist";
		}
			
		return "No Stock Selected";
		
	}
}
