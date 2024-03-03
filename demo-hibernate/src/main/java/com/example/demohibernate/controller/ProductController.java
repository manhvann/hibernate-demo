package com.example.demohibernate.controller;

import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Product;
import com.example.demohibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> get(){
         return productService.get();
    }

//    @GetMapping("/product")
//    public List<Product> get(){
//        return productService.get();
//    }

    @GetMapping("/product/{id}")
    public  Product get(@PathVariable int id){
        return productService.get(id);
    }

    @DeleteMapping("product/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }

    @PostMapping("/product")
    public void post(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
    }
}
