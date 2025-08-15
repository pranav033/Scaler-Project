package org.example.productcatalogservice.services;


import org.example.productcatalogservice.dtos.SortParams;
import org.example.productcatalogservice.dtos.SortType;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProductRepo productRepo;

    public Page<Product> searchProducts(String query, Integer pageSize, Integer pageNo, List<SortParams> sortParams)
    {
//        Sort sort = Sort.by("id").descending();
//        Sort overAllsort = Sort.by("price").descending().and(sort);
        Sort sort = null;
        if (sortParams != null && !sortParams.isEmpty()) {
            if(sortParams.get(0).getSortType().equals(SortType.ASCENDING))
                sort = sort.by(sortParams.get(0).getCriteria());
            else
                sort = sort.by(sortParams.get(0).getCriteria()).descending();

            for (int i = 1; i < sortParams.size(); i++) {
                if (sortParams.get(i).getSortType().equals(SortType.ASCENDING)) {
                    sort = sort.and(Sort.by(sortParams.get(i).getCriteria()));
                } else {
                    sort = sort.and(Sort.by(sortParams.get(i).getCriteria()).descending());
                }
            }
        }
        Pageable request = PageRequest.of(pageNo, pageSize,sort);// Example of sorting by price in descending order
        return productRepo.findAllByNameContains(query,request);
    }

}
