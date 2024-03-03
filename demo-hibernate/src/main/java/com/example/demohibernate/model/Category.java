package com.example.demohibernate.model;

import com.example.demohibernate.dto.CategoryDTO;
import jakarta.persistence.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private int id;

    private String name;


    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<Product> products;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
