package org.example.productcatalogservice.controllers;

import org.example.productcatalogservice.dtos.SearchRequestDto;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

        // Assuming you have a service to handle the search logic
        @Autowired
        private SearchService searchService;


        @PostMapping("")
        Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto)
        {
            String query = searchRequestDto.getQuery();
            if (query == null || query.isEmpty()) {
                throw new IllegalArgumentException("Search query cannot be null or empty");
            }
            // Assuming you have a service to handle the search logic
            Page<Product> products = searchService.searchProducts(query,searchRequestDto.getPageSize(),searchRequestDto.getPageNo(),searchRequestDto.getSortParams());
            return products;
        }
}
