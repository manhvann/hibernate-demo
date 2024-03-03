package com.example.demohibernate.controller;

import com.example.demohibernate.dto.CategoryDTO;
import com.example.demohibernate.dto.ProductDTO;
import com.example.demohibernate.model.Category;
import com.example.demohibernate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryDTO> get(){
        return categoryService.get();
    }

    @GetMapping("/category/{id}")
    public Category get(@PathVariable int id){
        return categoryService.get(id);
    }

    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }

    @PostMapping("/category")
    public void post(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
    }

    @DeleteMapping("/category")
    public void deleteProduct(@RequestParam(name = "category_id") int category_id, @RequestParam(name = "product_id") int product_id){
        categoryService.deleteProduct(category_id,product_id);
    }

    @GetMapping("category/listproduct/{id}")
    public List<ProductDTO> getList(@PathVariable int id){
        return categoryService.getListProduct(id);
    }
}
