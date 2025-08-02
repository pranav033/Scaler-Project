package org.example.productcatalogservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService iProductService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllProducts_RunSuccessfully() throws Exception {
        Product pr1 = new Product();
        pr1.setId(1l);
        pr1.setName("Iphone14");
        List<Product> products = new ArrayList<>();
        products.add(pr1);
        when(iProductService.getAllProducts()).thenReturn(products);


        ProductDto prdto1 = new ProductDto();
        prdto1.setId(1l);
        prdto1.setName("Iphone14");
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(prdto1);

        String value = objectMapper.writeValueAsString(productDtos);

        System.out.println(value);

        mockMvc.perform(get("/products"))
                .andExpect(MockMvcResultMatchers.content().string(value))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateProduct_RunSuccesfully() throws Exception {
        Product pr1 = new Product();
        pr1.setId(1l);
        pr1.setName("S24");
        when(iProductService.createProduct(any(Product.class))).thenReturn(pr1);
        ProductDto prdto1 = new ProductDto();
        prdto1.setId(1L);
        prdto1.setName("S24");
        String value = objectMapper.writeValueAsString(prdto1);

        mockMvc.perform(post("/products")
                        .content(value)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(value))
                .andExpect(status().isOk());
    }
}
