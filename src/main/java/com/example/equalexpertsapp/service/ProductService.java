package com.example.equalexpertsapp.service;

import com.example.equalexpertsapp.client.ProductClient;
import com.example.equalexpertsapp.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ProductService {

    private final ProductClient productClient;

    private final String baseUrl = "https://equalexperts.github.io/backend-take-home-test-data/";

    private final RestTemplate restTemplate;


    @Autowired
    public ProductService(ProductClient productClient, RestTemplate restTemplate) {
        this.productClient = productClient;
        this.restTemplate = restTemplate;
    }

    public ProductResponse getProduct(String product) {
        String url = baseUrl + product + ".json";

        ResponseEntity<ProductResponse> responseEntity = restTemplate.getForEntity(url, ProductResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("HTTP Request failed with status code: " + responseEntity.getStatusCode());
        }
    }

    public Double calculateCartSubtotal(ProductResponse productResponse){
        Double subTotal = 0D;
        Double price = productResponse.getPrice();
        double priceToTheNearestValue = Math.ceil(price);
        subTotal += priceToTheNearestValue;
        subTotal += subTotal * 0.125;
        return subTotal;
    }

    public Double AddProductsToCart(List<String> products){
        Double calculateCartSubtotal = 0D;
        for(String product : products){
            ProductResponse productResponse = getProduct(product);
            calculateCartSubtotal = calculateCartSubtotal(productResponse);
        }

        return calculateCartSubtotal;
    }
}
