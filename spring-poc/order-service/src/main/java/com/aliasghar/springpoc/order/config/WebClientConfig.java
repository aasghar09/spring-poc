package com.aliasghar.springpoc.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

//import io.netty.resolver.DefaultAddressResolverGroup;
//import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
	
	@LoadBalanced
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
		/*HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();*/
	}

}
