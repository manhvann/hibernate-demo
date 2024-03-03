package com.example.demohibernate.repository;

import com.example.demohibernate.dto.CategoryDTO;
import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<CategoryDTO> get();
    Category get(int id);
    void save(CategoryDTO categoryDTO);
    void delete(int id);
    void deleteProduct(int category_id, int product_id);
    List<ProductDTO> getListProduct(int id);
}
