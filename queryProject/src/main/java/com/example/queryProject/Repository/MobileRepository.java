package com.example.queryProject.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.queryProject.Model.Mobile;

public interface MobileRepository extends CrudRepository<Mobile,Integer> {
    @Query("SELECT p FROM Mobile p")
    List<Mobile> findAllModels();
    
    @Query("SELECT p FROM Mobile p WHERE p.price <=20000")
    List<Mobile> findBudgetModels();
    
    @Query("SELECT p FROM Mobile p WHERE p.type='Android'")
    List<Mobile> findAndroid();
    
    @Query("SELECT p FROM Mobile p WHERE p.type='iPhone'")
    List<Mobile> findiPhone();
}