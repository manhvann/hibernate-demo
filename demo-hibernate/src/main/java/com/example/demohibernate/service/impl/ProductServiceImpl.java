package com.example.demohibernate.service.impl;

import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Product;
import com.example.demohibernate.repository.ProductRepository;
import com.example.demohibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductDTO> get() {
        return productRepository.get();
    }

//    @Override
//    public List<Product> get() {
//        return productRepository.get();
//    }

    @Override
    public Product get(int id) {
        return productRepository.get(id);
    }

    @Transactional
    @Override
    public void save(ProductDTO productDTO) {
        productRepository.save(productDTO);
    }
    @Transactional
    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
}
