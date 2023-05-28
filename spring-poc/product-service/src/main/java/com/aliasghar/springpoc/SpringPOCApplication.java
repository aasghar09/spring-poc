package com.aliasghar.springpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.aliasghar.springpoc.model")
public class SpringPOCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPOCApplication.class, args);

	}

}
