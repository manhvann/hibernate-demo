package com.example.demohibernate.service.impl;

import com.example.demohibernate.dto.CategoryDTO;
import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Category;
import com.example.demohibernate.repository.CategoryRepository;
import com.example.demohibernate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> get() {
        return categoryRepository.get();
    }

    @Override
    public Category get(int id) {
        return categoryRepository.get(id);
    }

    @Transactional
    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryRepository.save(categoryDTO);
    }

    @Transactional
    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }
    @Transactional
    @Override
    public void deleteProduct(int category_id, int product_id) {
        categoryRepository.deleteProduct(category_id,product_id);
    }

    @Override
    public List<ProductDTO> getListProduct(int id) {
        return categoryRepository.getListProduct(id);
    }


}
