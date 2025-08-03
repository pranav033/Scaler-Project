package org.example.productcatalogservice.repositories;

import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;


//    @Test
    public void testQueries() {
//        List<Product> productList = productRepo.findAllByOrderByPrice();
//        for(Product product : productList) {
//            System.out.println(product.getPrice());
//        }

        System.out.println(productRepo.getMeNameOfMyFavouriteProductWhoseIdIWillGiveYou(2L));
    }

    @Test
    public void testAddProductIntoRds()
    {
        Product pr1 = new Product();
        pr1.setId(1L);
        pr1.setName("OnePlus 13");
        pr1.setPrice(50000d);
        Category cat1 = new Category();
        cat1.setId(11L);
        cat1.setName("Electronics");
        pr1.setCategory(cat1);
        productRepo.save(pr1);

        Product pr2 = new Product();
        pr2.setId(2L);
        pr2.setName("Nike Football");
        pr2.setPrice(8000d);
        Category cat2 = new Category();
        cat2.setId(22L);
        cat2.setName("Sports");
        pr2.setCategory(cat2);
        productRepo.save(pr2);

    }

//    public static void main(String args[]) {
//        testQueries();
//    }

}