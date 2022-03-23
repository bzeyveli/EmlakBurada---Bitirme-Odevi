package com.patika.emlakburada.repository;

import com.patika.emlakburada.model.entity.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    @Query("select x from Products x where x.userId = :id")
    List<Products> productAllById(Long id);
}
