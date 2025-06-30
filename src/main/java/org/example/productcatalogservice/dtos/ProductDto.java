package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice.models.Category;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private CategoryDto category;
}
