package com.example.dbproject2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.dbproject2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.dbproject2.models.BookModel; 

@Controller
public class BookController {

	@GetMapping("/addBook")
	public String addBook() {
	    return "bookForm";
	}
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String Product(BookModel bookData,Model model) {
	    //saving to database
	    BookModel n = new BookModel();
	    n.setTitle(bookData.getTitle());
	    n.setAuthor(bookData.getAuthor());    
	    n.setPrice(bookData.getPrice()); 
	    bookRepository.save(n);
	    //displaying all products
	    Iterable<BookModel> allBooks = bookRepository.findAll();
		model.addAttribute("books", allBooks);
	    return "allBooks"; 
	} 

}