package com.example.demohibernate.service;

import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> get();
//    List<Product> get();
    Product get(int id);
    void save(ProductDTO productDTO);
    void delete(int id);

}
