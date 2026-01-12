package com.example.dbproject1.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.dbproject1.models.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel,Integer> {

}