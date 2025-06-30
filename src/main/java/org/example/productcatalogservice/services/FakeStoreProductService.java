package org.example.productcatalogservice.services;

import org.example.productcatalogservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FakeStoreProductService implements IProductService{

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
