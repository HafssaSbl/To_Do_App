package com.example.gatewayserveur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServeurApplication.class, args);
	}

	@Bean
	DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
		//Configuration dynamique des routes
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}
}
