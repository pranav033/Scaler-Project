package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice.models.Product;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private String name;

    private String description;

}
