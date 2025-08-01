package org.example.productcatalogservice.controllers;


import org.example.productcatalogservice.dtos.CategoryDto;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        List<Product> products = iProductService.getAllProducts();
        List<ProductDto> productDtos = products.stream().map(x -> from(x)).collect(Collectors.toList());
        return productDtos;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
     //   try {
        if (productId < 0) {
            throw new IllegalArgumentException("Product Id not found");
        }
        else if(productId == 0) {
            throw new IllegalArgumentException("Products exist with positive id");
        }

            Product product = iProductService.getProductById(productId);
            if (product == null) return null;
            ProductDto productDto = from(product);
            return ResponseEntity.ok(productDto);

//        catch (IllegalArgumentException ex)
//        {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product outputProduct = iProductService.createProduct(product);
        if(outputProduct==null) return null;
        return from(outputProduct);
    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product output = iProductService.replaceProduct(product,id);
        if(output == null) return null;
        return from(output);
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if (product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }
}

