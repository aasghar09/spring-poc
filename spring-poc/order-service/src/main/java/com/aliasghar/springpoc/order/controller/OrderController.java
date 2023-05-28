package com.aliasghar.springpoc.order.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


import com.aliasghar.springpoc.shared.dto.*;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import jakarta.servlet.http.HttpServletRequest;
import reactor.core.publisher.Mono;




@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	//@Autowired
	//private LoadBalancerClient loadBalancerClient;

	 
	
	@RequestMapping(path = "/placeOrder")
	@CircuitBreaker(name = "ORD-PO", fallbackMethod = "fallBackPlaceOrder")
	//@TimeLimiter(name = "ORD-PO")
	public String placeOrder(@RequestBody  OrderDTO orderDTO,HttpServletRequest request) 
	{
		
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		
		if(authorizationHeader == null) {
			authorizationHeader= "";
		}

		//List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
		//ServiceInstance instance = instances.get(0);
		//String uri = instance.getUri().toString();
		//ServiceInstance instance = loadBalancerClient.choose("product-service");
		//String uri = instance.getUri().toString();
		String response=webClientBuilder.build().post()
		//.uri(uri+"/api/product/placeOrder")
		.uri("http://gateway-service/api/product/placeOrder")
		//.uri("http://gateway-service/api/product/placeOrder")		
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.header(HttpHeaders.AUTHORIZATION, authorizationHeader)
		.body(Mono.just(orderDTO),OrderDTO.class)
		.retrieve()
		.bodyToMono(String.class)
		.block();
		
		return response;
	}
	
	public String fallBackPlaceOrder(RuntimeException RuntimeException)
	{
		return "There seems to be some problem.Kindly place your order again shorlty.";
	}
}
