package com.example.apiProject1.exception;

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(Long id){
        super("Could not found the product with id "+ id);
    }
}