package com.example.apiProject2.controllers;

import com.example.apiProject2.exception.BookNotFoundException;
import com.example.apiProject2.models.Books;
import com.example.apiProject2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3002")
public class ApiController {


    @Autowired
    private BookRepository bookRepository;


    @PostMapping("api/addbook")
    Books newBook(@RequestBody Books newBook) {
        return bookRepository.save(newBook);
    }


    @GetMapping("api/listbooks")
    List<Books> getAllBooks() {
        return bookRepository.findAll();
    }


    @GetMapping("api/book/{id}")
    Books getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }


    @PutMapping("api/updatebook/{id}")
    Books updateBook(@RequestBody Books newBook, @PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    book.setGenre(newBook.getGenre());
                    book.setPrice(newBook.getPrice());
                    book.setPublished(newBook.getPublished());
                    return bookRepository.save(book);
                }).orElseThrow(() -> new BookNotFoundException(id));
    }

    @DeleteMapping("api/deletebook/{id}")
    String deleteBook(@PathVariable Long id){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
        return  "Book with id "+id+" has been deleted successfully.";
    }
    
     @GetMapping("api/search")
        List<Books> searchBook(@Param("keyword") String keyword) {
    	 List<Books> result = bookRepository.findAllByKeyword(keyword); 
    	 if(result.isEmpty()) {
    		 throw new BookNotFoundException(keyword);
    	 }
    	 return result;
            		
        }
}