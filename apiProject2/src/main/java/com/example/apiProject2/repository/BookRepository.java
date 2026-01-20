package com.example.apiProject2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.example.apiProject2.models.Books;



public interface BookRepository extends JpaRepository<Books, Long> {
	@Query("SELECT p FROM Books p WHERE p.title LIKE %:keyword%")
    List<Books> findAllByKeyword(@Param("keyword") String keyword);
}