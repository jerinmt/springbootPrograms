package com.example.dbproject1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.dbproject1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.dbproject1.models.ProductModel; 

@Controller
public class ProductController {

	@GetMapping("/product")
	public String Product() {
	    return "addForm";
	}
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/addProduct")
	public String Product(ProductModel productData,Model model) {
	    //saving to database
	    ProductModel n = new ProductModel();
	    n.setName(productData.getName());
	    n.setDescription(productData.getDescription());    
	    n.setPrice(productData.getPrice()); 
	    productRepository.save(n);
	    //displaying all products
	    Iterable<ProductModel> products = productRepository.findAll();
		model.addAttribute("products", products);
	    return "productList"; 
	} 

}