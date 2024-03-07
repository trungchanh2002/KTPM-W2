package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/users/**")
                        .uri("http://localhost:8081")
                        .id("user-service"))
                .route(r -> r.path("/api/products/**")
                        .uri("http://localhost:8082")
                        .id("product-service"))
                .build();
    }
}
