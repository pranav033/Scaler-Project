package org.example.productcatalogservice.controllers;


import org.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> l1 = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1l);
        p1.setName("Iphone");
        Product p2 = new Product();
        p2.setName("Samsung");
        p2.setId(2l);
        l1.add(p2);
        l1.add(p1);
        return l1;
    }

//    @GetMapping("/products/{id}")
//    public  Product getProductById(@PathVariable("id") Long productId) {
//        return null;
//    }
//
//    @PostMapping("products")
//    public Product createProduct(@RequestBody Product productDto) {
//        return productDto;
//    }

}
