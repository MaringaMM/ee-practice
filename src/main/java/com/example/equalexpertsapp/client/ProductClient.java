package com.example.equalexpertsapp.client;

import com.example.equalexpertsapp.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "https://equalexperts.github.io")
public interface ProductClient {

    @GetMapping("/backend-take-home-test-data/{product}.json")
    ProductResponse getProduct(@PathVariable ("product") String product);
}
