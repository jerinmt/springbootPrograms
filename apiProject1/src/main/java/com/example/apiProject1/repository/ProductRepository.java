package com.example.apiProject1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.example.apiProject1.models.Products;



public interface ProductRepository extends JpaRepository<Products, Long> {
	@Query("SELECT p FROM Products p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword% OR p.category LIKE %:keyword%")
    List<Products> findAllByKeyword(@Param("keyword") String keyword);
}