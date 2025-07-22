package org.example.productcatalogservice.controllers;

import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    //arrange
    @Autowired
    private ProductController productController;

    @MockBean
    private IProductService iProductService;

    @Test
    void getAllProducts() {
    }

    @Test
    void TestgetProductById_RunSuccessfully() {
        //arrange
        Long id = 1l;
        Product pr1 = new Product();
        pr1.setId(id);
        when(iProductService.getProductById(id)).thenReturn(pr1);
        //act
        ResponseEntity<ProductDto> productById = productController.getProductById(id);
        //assert
        assertNotNull(productById);
        assertNotNull(productById.getBody());
        //assert(productById.getBody().getId()==id);
        assertEquals(id,productById.getBody().getId());
        verify(iProductService,times(1)).getProductById(id);
    }

    @Test
    void testGetProductById_NegetiveId_IllegalArgumentExceptionExpected() {
        assertThrows(IllegalArgumentException.class,()->productController.getProductById(-2l));
        verify(iProductService,times(0)).getProductById(-2l);
    }

    @Test
    public void testGetProductById_WithZeroId_ThrowsIllegalArgumentException() {
        //Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> productController.getProductById(0L));

        assertEquals("Products exist with positive id", exception.getMessage());
        verify(iProductService,times(0)).getProductById(0L);
    }
}