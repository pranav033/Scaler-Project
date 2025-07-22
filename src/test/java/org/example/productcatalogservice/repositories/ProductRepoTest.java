package org.example.productcatalogservice.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;


    @Test
    public void testQueries() {
//        List<Product> productList = productRepo.findAllByOrderByPrice();
//        for(Product product : productList) {
//            System.out.println(product.getPrice());
//        }

        System.out.println(productRepo.getMeNameOfMyFavouriteProductWhoseIdIWillGiveYou(2L));
    }

//    public static void main(String args[]) {
//        testQueries();
//    }

}