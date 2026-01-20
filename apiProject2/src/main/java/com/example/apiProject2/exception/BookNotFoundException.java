package com.example.apiProject2.exception;

public class BookNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public BookNotFoundException(Long id){
        super("Could not find the book with id "+ id);
    }
}