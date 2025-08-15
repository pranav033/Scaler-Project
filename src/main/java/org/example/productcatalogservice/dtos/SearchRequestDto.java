package org.example.productcatalogservice.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDto {

    private String query;
    private Integer pageSize;
    private Integer pageNo;
    List<SortParams> sortParams;
}
