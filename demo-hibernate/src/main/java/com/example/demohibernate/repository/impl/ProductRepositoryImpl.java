package com.example.demohibernate.repository.impl;

import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Category;
import com.example.demohibernate.model.Product;
import com.example.demohibernate.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<ProductDTO> get() {
//        List<Product> list =  entityManager.createQuery("From Product").getResultList();
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        for (Product p: list){
//            ProductDTO productDTO = new ProductDTO();
//            productDTO.setId(p.getId());
//            productDTO.setName(p.getName());
//            productDTO.setDescription(p.getDescription());
//            productDTO.setPrice(p.getPrice());
//            productDTO.setCategory_id(p.getCategory().getId());
//            productDTOList.add(productDTO);
//        }
//        return productDTOList;
        return entityManager.createQuery("From ProductDTO ").getResultList();
    }

//    @Override
//    public List<Product> get() {
//        for (Object object: entityManager.createQuery("From Product ").getResultList()){
//            Product p = (Product) object;
//            Category category = p.getCategory();
//            System.out.println(category.getName());
//        }
//        return entityManager.createQuery("From Product ").getResultList();
//    }

    @Override
    public Product get(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public void save(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        Category category = entityManager.find(Category.class,productDTO.getCategory_id());
        product.setCategory(category);

        entityManager.persist(product);
    }

    @Override
    public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }
}
