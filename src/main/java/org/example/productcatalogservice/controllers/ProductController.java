package org.example.productcatalogservice.controllers;


import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return null;
    }

    @GetMapping("/products/{id}")
    public  ProductDto getProductById(@PathVariable("id") Long productId) {
        return null;
    }

    @PostMapping("products")
    public Product createProduct(@RequestBody Product productDto) {
        return productDto;
    }

}
