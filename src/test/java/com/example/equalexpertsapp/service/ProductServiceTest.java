package com.example.equalexpertsapp.service;

import com.example.equalexpertsapp.client.ProductClient;
import com.example.equalexpertsapp.client.ProductRestTemplate;
import com.example.equalexpertsapp.dto.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void mapProductResponse() {
        productService.getProduct("cheerios");
    }

    @Test
    void calculateCartSubtotal() {
    }

    @Test
    void addProductsToCart() {
    }
}