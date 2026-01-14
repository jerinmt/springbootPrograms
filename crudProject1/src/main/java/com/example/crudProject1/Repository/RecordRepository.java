package com.example.crudProject1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.crudProject1.Models.RecordModel;
import java.util.List;

public interface RecordRepository extends JpaRepository<RecordModel, Integer> {
	@Query("SELECT p FROM RecordModel p WHERE p.name LIKE %:keyword%")
    List<RecordModel> findAllByKeyword(@Param("keyword") String keyword);
}
