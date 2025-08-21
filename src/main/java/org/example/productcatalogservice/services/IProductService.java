package org.example.productcatalogservice.services;

import org.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(Long id);

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product replaceProduct(Product product, Long id);

    Product getProductDetailsBasedOnUserScope(Long userId, Long prodId);

}
