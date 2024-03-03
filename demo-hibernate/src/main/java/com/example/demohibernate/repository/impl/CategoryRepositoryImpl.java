package com.example.demohibernate.repository.impl;

import com.example.demohibernate.dto.CategoryDTO;
import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.dto.mapping.ProductMapping;
import com.example.demohibernate.model.Category;
import com.example.demohibernate.model.Product;
import com.example.demohibernate.repository.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CategoryDTO> get() {
        return entityManager.createQuery("FROM CategoryDTO ").getResultList();
    }

    @Override
    public Category get(int id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        entityManager.persist(categoryDTO);
    }

    @Override
    public void delete(int id) {
        Category category = entityManager.find(Category.class,id);
        entityManager.remove(category);
    }

    @Override
    public void deleteProduct(int category_id, int product_id) {
        Category category = entityManager.find(Category.class,category_id);
        Product product = entityManager.find(Product.class,product_id);
        category.getProducts().remove(product);
        entityManager.merge(category);
    }

    @Override
    public List<ProductDTO> getListProduct(int id) {
        Category category = entityManager.find(Category.class,id);
        Set<Product> products = category.getProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product p:products){
            ProductDTO productDTO =  ProductMapping.mappingToProductDTO(p);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
}
