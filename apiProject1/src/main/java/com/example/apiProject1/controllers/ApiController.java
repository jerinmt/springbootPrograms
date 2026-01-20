package com.example.apiProject1.controllers;

import com.example.apiProject1.exception.ProductNotFoundException;
import com.example.apiProject1.models.Products;
import com.example.apiProject1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3002")
public class ApiController {


    @Autowired
    private ProductRepository productRepository;


    @PostMapping("api/addproduct")
    Products newProduct(@RequestBody Products newProduct) {
        return productRepository.save(newProduct);
    }


    @GetMapping("api/listproducts")
    List<Products> getAllProducts() {
        return productRepository.findAll();
    }


    @GetMapping("api/product/{id}")
    Products getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


    @PutMapping("api/updateproduct/{id}")
    Products updateProduct(@RequestBody Products newProduct, @PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setExpiry(newProduct.getExpiry());
                    product.setCategory(newProduct.getCategory());
                    product.setStock(newProduct.getStock());
                    return productRepository.save(product);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @DeleteMapping("api/deleteproduct/{id}")
    String deleteProduct(@PathVariable Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        return  "Product with id "+id+" has been deleted success.";
    }
    
     @GetMapping("api/search")
        List<Products> searchProducts(@Param("keyword") String keyword) {
    	 return productRepository.findAllByKeyword(keyword);
            		
        }
}