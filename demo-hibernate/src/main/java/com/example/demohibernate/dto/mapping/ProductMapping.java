package com.example.demohibernate.dto.mapping;

import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Category;
import com.example.demohibernate.model.Product;
import jakarta.persistence.EntityManager;

public class ProductMapping {
    public static Product mappingToProduct(EntityManager entityManager, ProductDTO productDTO){
        Product p = new Product();
        p.setId(productDTO.getId());
        p.setName(productDTO.getName());
        p.setDescription(productDTO.getDescription());
        p.setPrice(productDTO.getPrice());
        p.setCategory(entityManager.find(Category.class,productDTO.getCategory_id()));
        return p;
    }
    public static ProductDTO mappingToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory_id(product.getCategory().getId());
        return productDTO;
    }
}
