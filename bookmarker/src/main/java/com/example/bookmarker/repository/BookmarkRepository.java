package com.example.bookmarker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.bookmarker.models.Bookmarks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmarks, Integer> {
	@Query("SELECT p FROM Bookmarks p WHERE p.username=:username AND (p.title LIKE %:keyword% OR p.savedURL LIKE %:keyword%)")
    List<Bookmarks> findAllByKeyword(@Param("keyword") String keyword, String username);
	
	Page<Bookmarks> findByUsername(String username, Pageable pageable);
	
	@Query("SELECT p FROM Bookmarks p WHERE p.username=:username AND p.id=:id")
	Optional<Bookmarks> findBy(String username, Integer id);
}
