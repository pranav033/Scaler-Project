package org.example.productcatalogservice.services;

import org.example.productcatalogservice.dtos.UserDto;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService{
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> optionalProduct = productRepo.findById(product.getId());
        if(optionalProduct.isEmpty()) {
            return productRepo.save(product);
        }

        return optionalProduct.get();
    }

    @Override
    public Product replaceProduct(Product input, Long id) {
        input.setId(id);
        return productRepo.save(input);
    }

    @Override
    public Product getProductDetailsBasedOnUserScope(Long userId, Long prodId) {
        Optional<Product> productOptional = productRepo.findById(prodId);
        if (productOptional.isEmpty()) {
            return null;
        }
        ResponseEntity<UserDto> userDtoResponseEntity = restTemplate.getForEntity("http://userauthservice/users/{userId}", UserDto.class, userId);
        System.out.println(userDtoResponseEntity.getBody().getEmail());
        Product product = productOptional.get();
        return product;


    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
