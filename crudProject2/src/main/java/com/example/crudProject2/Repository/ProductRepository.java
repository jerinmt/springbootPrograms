package com.example.crudProject2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudProject2.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}