package org.example.productcatalogservice.repositories;

import jakarta.transaction.Transactional;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo ;

    @Test
    @Transactional //Why I am adding this ?
    public  void testLoading() {
        Optional<Category> categoryOptional = categoryRepo.findById(2L);
        for(Product p : categoryOptional.get().getProducts()) {
            System.out.println(p.getName());
        }
    }


    @Test
    @Transactional
    public void testForAllCategoriesForSubselect()
    {
        List<Category> categories = categoryRepo.findAll();
        for(Category c : categories)
        {
            for(Product p : c.getProducts())
            {
                System.out.println(p.getName());
            }
        }
    }

}