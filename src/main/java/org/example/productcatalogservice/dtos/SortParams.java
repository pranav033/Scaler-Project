package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParams {

    private String criteria;
    private SortType sortType;
}
