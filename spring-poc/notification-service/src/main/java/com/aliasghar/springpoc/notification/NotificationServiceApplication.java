package com.aliasghar.springpoc.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

import com.aliasghar.springpoc.shared.dto.OrderCompletionEventDTO;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	
	@KafkaListener(topics = "orderCompletionNotification",groupId = "OrderCompletionGroup")
	public void handleOrderCompletionNotification(OrderCompletionEventDTO orderCompletionEventDTO) {
		System.out.println("Your order with order number"+orderCompletionEventDTO.getOrderNumber()+" has place succesfully");
		
	}

}
