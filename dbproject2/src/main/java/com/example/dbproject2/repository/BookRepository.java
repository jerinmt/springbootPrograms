package com.example.dbproject2.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.dbproject2.models.BookModel;

public interface BookRepository extends CrudRepository<BookModel,Integer> {

}